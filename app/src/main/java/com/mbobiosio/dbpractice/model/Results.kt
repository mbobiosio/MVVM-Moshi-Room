package com.mbobiosio.dbpractice.model

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
sealed class Results<out T> {
    data class Success<out T>(val value: T) : Results<T>()
    data class Error(val error: Int? = null, val message: APIResponse? = null) : Results<Nothing>()
    data class ErrorMessage(val message: String? = null) : Results<Nothing>()
    object NetworkError : Results<Nothing>()
}