package com.nlgtuankiet.fera.function

import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Request

data class WorkflowResult(
  val id: String,
  val status: String,
  val duration: Int,
  val credits_used: Int
)

data class WorkflowResultResponse(
  val items: List<WorkflowResult>
)

fun getAllWorkflowResult(workflow: String, branch: String): List<WorkflowResult> {
  println("getAllWorkflowResult $workflow $branch")
  val request = "https://circleci.com/api/v2/insights/github/nlgtuankiet/fera/workflows/$workflow"
    .toHttpUrl()
    .newBuilder()
    .addQueryParameter("circle-token", System.getenv("FERA_CIRCLE_CI_TOKEN"))
    .addQueryParameter("branch", branch)
    .build().let {
      println("url: $it")
      Request.Builder().url(it).build()
    }
  val json = okHttpClient.newCall(request).execute().body!!.string()
  println(json)
  val response = gson.fromJson(json, WorkflowResultResponse::class.java)
  return response.items
}

fun <T> List<T>.tpOf(percent: Float, factorProvider: (T) -> Number): Float {
  var current = 0f
  forEachIndexed { index, item ->
    val currentPercent = (index + 1f) / size
    if (currentPercent > percent) {
      return (current + factorProvider.invoke(item).toFloat()) / 2
    } else {
      current = factorProvider.invoke(item).toFloat()
    }
  }
  error("")
}

fun insightOf(workflow: String, branch: String) {
  val rawItems = getAllWorkflowResult(workflow, branch)
  val successItems = rawItems
    .filter { it.status == "success" }
  val timeTp95 = successItems.tpOf(0.95f) { it.duration }
  val timeMin = successItems.minBy { it.duration }!!.duration
  val timeMax = successItems.maxBy { it.duration }!!.duration
  val timeAverage = successItems.map { it.duration }.average()

  val creditTp95 = successItems.tpOf(0.95f) { it.credits_used }
  val creditMin = successItems.minBy { it.credits_used }!!.credits_used
  val creditMax = successItems.maxBy { it.credits_used }!!.credits_used
  val creditAverage = successItems.map { it.credits_used }.average()

  val successRate = successItems.size.toFloat() * 100 / rawItems.size
  fun Number.toMinutes(): String {
    val minutes = this.toFloat() / 60
    return "(%.2f minutes)".format(minutes)
  }

  println("timeTp95: $timeTp95 seconds ${timeTp95.toMinutes()}")
  println("timeMin: $timeMin seconds ${timeMin.toMinutes()}")
  println("timeMax: $timeMax seconds ${timeMax.toMinutes()}")
  println("timeAverage: $timeAverage seconds ${timeAverage.toMinutes()}")
  println("")
  println("creditTp95: $creditTp95")
  println("creditMin: $creditMin")
  println("creditMax: $creditMax")
  println("creditAverage: $creditAverage")
  println("")
  println("success rate: %.2f".format(successRate) + "%")
  println("total: ${rawItems.size}")
  println("total success : ${successItems.size}")
  println("total fail : ${rawItems.size - successItems.size}")
}
