package com.nlgtuankiet.fera.function

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.util.concurrent.TimeUnit

val gson = Gson()

val okHttpClient = OkHttpClient.Builder()
  .callTimeout(1, TimeUnit.DAYS)
  .connectTimeout(1, TimeUnit.DAYS)
  .addNetworkInterceptor(object : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
      val request = chain.request()
      return chain.proceed(request)
    }
  })
  .build()