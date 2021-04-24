package com.mbobiosio.dbpractice.api

import com.mbobiosio.dbpractice.model.BaseResponse
import com.mbobiosio.dbpractice.model.User
import com.mbobiosio.dbpractice.model.Post
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
interface ApiService {

    @POST("GetFanFeedsPosts")
    suspend fun getPosts(
        @Query("userID") UserId: Int?,
        @Query("pageNumber") pageNumber: Int?
    ): BaseResponse<Post>

    @GET("GetFollowersByUserID")
    suspend fun getUsers(
        @Query("UserID") userID: Int?,
        @Query("pageNumber") pageNumber: Int?
    ): BaseResponse<User>
}