package com.nlgtuankiet.fera.core.result

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.internal.SuppressSignatureCheck
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Singleton
class ResultManager @Inject constructor() {

  private val requests = HashMap<String, CancellableContinuation<*>>()

  suspend fun <T> getResult(requestCode: String): T = suspendCancellableCoroutine { continuation ->
    requests[requestCode] = continuation
  }

  // TODO validate on failed
  fun <T> sendResult(requestCode: String, result: T) {
    getRequest<T>(requestCode)?.resume(result)
    requests.remove(requestCode)
  }

  fun cancel(requestCode: String) {
    val request = getRequest<Any>(requestCode)
    println("cancel request: $request")
    request?.cancel()
    requests.remove(requestCode)
  }

  private fun <T> getRequest(requestCode: String): CancellableContinuation<T>? {
    val request = requests[requestCode] ?: return null
    @Suppress("UNCHECKED_CAST")
    return request as? CancellableContinuation<T>
  }

}