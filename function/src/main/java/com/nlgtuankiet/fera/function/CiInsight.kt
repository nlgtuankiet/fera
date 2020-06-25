package com.nlgtuankiet.fera.function

import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Request

data class WorkflowResult(
  val id: String,
  val status: String,
  val duration: Int,
  val credits_used: Int,
  val created_at: String
)

data class WorkflowResultResponse(
  val items: List<WorkflowResult>,
  val next_page_token: String? = null
)

fun getAllWorkflowResult(workflow: String, branch: String): List<WorkflowResult> {
  println("getAllWorkflowResult $workflow $branch")
  fun createRequest(nextPageToken: String?): Request {
    return "https://circleci.com/api/v2/insights/github/nlgtuankiet/fera/workflows/$workflow"
      .toHttpUrl()
      .newBuilder()
      .addQueryParameter("circle-token", System.getenv("FERA_CIRCLE_CI_TOKEN"))
      .addQueryParameter("branch", branch)
      .apply {
        if (nextPageToken != null) {
          addQueryParameter("page-token", nextPageToken)
        }
      }
      .build().let {
        println("url: $it")
        Request.Builder().url(it).build()
      }
  }

  val result = mutableListOf<WorkflowResult>()
  var nextPageToken: String? = null
  do {
    val request = createRequest(nextPageToken)
    val json = okHttpClient.newCall(request).execute().body!!.string()
    println(json)
    val response = gson.fromJson(json, WorkflowResultResponse::class.java)
    result.addAll(response.items)
    nextPageToken = response.next_page_token
  } while (!nextPageToken.isNullOrBlank())
  return result
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

fun insightOf(workflow: String, branch: String, limit: Int) {
  val rawItems = getAllWorkflowResult(workflow, branch)
    .sortedByDescending { it.created_at }
    .take(limit)
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
