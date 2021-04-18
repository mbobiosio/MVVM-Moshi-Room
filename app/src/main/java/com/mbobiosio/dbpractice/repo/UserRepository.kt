package com.mbobiosio.dbpractice.repo

import com.mbobiosio.dbpractice.api.RetrofitClient
import com.mbobiosio.dbpractice.model.Follower
import com.mbobiosio.dbpractice.model.Results

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class UserRepository : BaseRepository() {
    private val apiService = RetrofitClient.apiService

    suspend fun getFollowers(
        userId: Int?
    ): Results<List<Follower>> {
        return coroutineHandler(dispatcher) {
            apiService.getFollowers(userId)
        }
    }
}