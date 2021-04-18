package com.mbobiosio.dbpractice.model

import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class BaseResponse<T: Response>(
    @Json(name = "page")
    val page: String?,

    @Json(name = "results")
    val results: List<T>,

    @Json(name = "total_results")
    val totalResults: Int?,

    @Json(name = "total_pages")
    val totalPages: Int?
)
