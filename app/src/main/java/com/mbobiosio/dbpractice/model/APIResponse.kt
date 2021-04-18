package com.mbobiosio.dbpractice.model

import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class APIResponse(
    @Json(name = "StatusCode")
    val status: Int?,
    @Json(name = "Message")
    val message: String?,
)
