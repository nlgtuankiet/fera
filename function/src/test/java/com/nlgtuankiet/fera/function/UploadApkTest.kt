package com.nlgtuankiet.fera.function

import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.http.client.methods.RequestBuilder
import org.junit.Test

class UploadApkTest {
  @Test
  fun upload() {
    //  curl -v -F fileName=value1 -F 'fileContent=@/aa.apk' https://us-central1-fera-verto.cloudfunctions.net/uploadApk
    val request = Request.Builder()
      .post(
        MultipartBody.Builder()
          .addFormDataPart("fileName", "testFileName")
          .addFormDataPart("fileContent", "testFileContent", "aaa".toRequestBody())
          .setType(MultipartBody.FORM)
          .build()
      )
      .url("https://us-central1-fera-verto.cloudfunctions.net/uploadApk")
      .build()
    val response = OkHttpClient.Builder()
      .apply {
        addNetworkInterceptor(
          HttpLoggingInterceptor(
            object : HttpLoggingInterceptor.Logger {
              override fun log(message: String) {
                println(message)
              }

            }
          ).apply { level = HttpLoggingInterceptor.Level.BODY }
        )
      }
      .build()
      .newCall(request).execute()
    println("status code ${response.code}")
    require(response.isSuccessful)
  }
}