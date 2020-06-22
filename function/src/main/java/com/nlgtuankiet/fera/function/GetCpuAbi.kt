package com.nlgtuankiet.fera.function

import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Request
import org.jsoup.Jsoup
import java.io.File
import kotlin.system.exitProcess

enum class Abi {
  Arm,
  Arm64,
  X86,
  X86X64,
}

data class SearchResultEntry(
  val url: String,
)

data class ModelRow(
  val mobile_brand_name: String,
  val mobile_os_hardware_model: String,
  val count: String,
)

data class ModelInfo(
  val row: ModelRow,
  val abi: Abi?
)

fun getCpuAbis(inputPath: String, startWith: String? = null) = runBlocking {
  val inputJson = File(inputPath).readText()
  val input = gson.fromJson<List<ModelRow>>(
    inputJson,
    TypeToken.getParameterized(List::class.java, ModelRow::class.java).type
  ).let {
    val startIndex = it.indexOfFirst { it.mobile_os_hardware_model == startWith }
      .let { it - 1 }
      .coerceAtLeast(0)
    it.subList(startIndex, it.size - 1)
  }.take(100)
  val result = mutableMapOf<Abi?, Int>()

  processModels(input, 1).forEach { modelInfo ->
    val abi = modelInfo.abi
    result[abi] = ((result[abi] ?: 0) + modelInfo.row.count.toInt())
  }
  println(result)
}

private suspend fun processModels(models: List<ModelRow>, worker: Int) = coroutineScope {
  val modelChannel = produce {
    models.forEach { send(it) }
  }
  val articles = Channel<ModelInfo>()
  repeat(worker) { workerNo ->
    launch(Dispatchers.IO) {
      for (model in modelChannel) {
        println("worker #$workerNo find $model")
        val abi = kotlin.runCatching { getCpuAbi(model.mobile_os_hardware_model) }
          .onFailure {
            it.printStackTrace()
          }
          .getOrNull()
        println("${model.mobile_brand_name} ${model.mobile_os_hardware_model} is $abi")
        articles.send(ModelInfo(row = model, abi = abi))
      }
    }
  }
  articles.consumeAsFlow().take(models.size).toList()
}

fun getCpuAbi(modelName: String): Abi {
  val searchRequest = Request.Builder()
    .url(
      "https://www.devicespecifications.com/index.php?action=search&language=en".toHttpUrl()
        .newBuilder()
        .addQueryParameter("search", modelName)
        .build()
    )
    .build()
  println("request url is ${searchRequest.url}")
  val searchResponse = okHttpClient.newCall(searchRequest).execute()
  val searchResponseString = searchResponse.body?.string()
  println("searchResponseString is $searchResponseString, code is ${searchResponse.code}")
  require(searchResponse.isSuccessful)
  val response = gson.fromJson<List<SearchResultEntry>>(
    searchResponseString,
    TypeToken.getParameterized(List::class.java, SearchResultEntry::class.java).type
  )
  val firstEntry = response.first()

  val devicePageDocument = Request.Builder().url(firstEntry.url).build()
    .let {
      okHttpClient.newCall(it).execute().body!!.string().also {
        println("json for $modelName is $it")
      }
    }
    .let { Jsoup.parse(it) }
  val abiName = devicePageDocument.select("tr")
    .first {
      it.selectFirst("td").text().contains("Instruction set")
    }
    .select("td")[1]
    .text().trim().toLowerCase()
  return when (abiName) {
    "armv8-a" -> Abi.Arm64
    "armv8" -> Abi.Arm64
    "armv8.2-a" -> Abi.Arm64
    "armv7" -> Abi.Arm
    "armv7-a" -> Abi.Arm
    else -> {
      println("unknown name: $abiName for model $modelName link: ${firstEntry.url}")
      exitProcess(1)
    }
  }
}
