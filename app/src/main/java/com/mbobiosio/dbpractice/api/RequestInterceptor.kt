package com.mbobiosio.dbpractice.api

import okhttp3.Interceptor
import okhttp3.Response

/*
* Created by Mbuodile Obiosio on Apr 25, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "Bearer WsKJo0qRJXAfIIuL2iAbRNDHcamGe6c9GULZQOiy7hBTPNRhuHj8Igbs_h8-noGWrrDspuFPPhncf3I3DW2ruObDw95PULQiKmqXkLyEy2Fq23TtuhJCl9yTN8gHRHlLzfZLUxBt-LbtHimKN58KKe4JPWJ3i80n0L4V09FXXkUhlBfeMWKrVqpQgWXouzFc5gWHyi-ia0g_0UukMOHWcFPQ5TLGOpVMtpCqBS919vwrzBhlOuv7aDOMGnehwgXnWDCj7eNROpeWd1n5f03-zw"
            ).build()
        return chain.proceed(request)
    }
}