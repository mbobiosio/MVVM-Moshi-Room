package com.mbobiosio.dbpractice.api

import com.mbobiosio.dbpractice.model.BaseResponse
import com.mbobiosio.dbpractice.model.Follower
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
    suspend fun getFollowers(
        @Query("UserID") userID: Int?
    ): List<Follower>
}