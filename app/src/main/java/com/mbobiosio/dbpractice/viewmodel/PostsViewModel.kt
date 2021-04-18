package com.mbobiosio.dbpractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mbobiosio.dbpractice.api.RetrofitClient
import com.mbobiosio.dbpractice.data.PostDataSource

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class PostsViewModel : ViewModel() {

    private val apiService = RetrofitClient.apiService

    private val dataSource = PostDataSource(
        apiService
    )

    private val pagingConfig = PagingConfig(
        pageSize = 10, initialLoadSize = 10, enablePlaceholders = false
    )

    val feed = Pager(pagingConfig) {
        dataSource
    }.flow.cachedIn(viewModelScope)
}