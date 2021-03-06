package com.mbobiosio.dbpractice.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
object RetrofitClient {
    val apiService by lazy { apiService<ApiService>() }
}

private fun httpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    return OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
            .addInterceptor(RequestInterceptor())
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
    }.build()
}

private fun getMoshi(): Moshi {
    return Moshi.Builder().apply {
        this.add(KotlinJsonAdapterFactory())
    }.build()
}

private fun getRetrofit(): Retrofit {
    return Retrofit.Builder().apply {
        baseUrl("http://futbalbuz-001-site1.itempurl.com/")
        client(httpClient())
        addConverterFactory(MoshiConverterFactory.create(getMoshi()))
    }.build()
}
private inline fun <reified T> apiService(): T = getRetrofit().create(T::class.java)