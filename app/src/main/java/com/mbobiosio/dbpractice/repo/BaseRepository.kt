package com.mbobiosio.dbpractice.repo

import com.mbobiosio.dbpractice.model.APIResponse
import com.mbobiosio.dbpractice.model.Results
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import timber.log.Timber

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
open class BaseRepository {

    suspend fun <T> coroutineHandler(
        dispatcher: CoroutineDispatcher,
        apiRequest: suspend () -> T
    ): Results<T> {
        return withContext(dispatcher) {
            try {
                Results.Success(apiRequest.invoke())
            } catch (e: IOException) {
                Results.NetworkError
            } catch (e: HttpException) {
                val errorCode = e.code()
                val errorMessage = throwableResponse(e)
                Timber.d("Network Error $errorCode : ${errorMessage?.status} : ${errorMessage?.message}")
                Results.Error(errorCode, errorMessage)
            } catch (t: Throwable) {
                Results.ErrorMessage(t.message)
                Results.Error(null, null)
            }
        }
    }

    open val dispatcher = Dispatchers.IO

    private fun throwableResponse(e: HttpException): APIResponse? {
        return try {
            e.response()?.errorBody()?.source()?.let {
                val moshiAdapter = Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
                    .adapter(APIResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (t: Throwable) {
            Timber.d("Error $t")
            null
        }
    }
}