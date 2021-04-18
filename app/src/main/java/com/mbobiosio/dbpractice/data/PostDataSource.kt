package com.mbobiosio.dbpractice.data

import androidx.paging.PagingSource
import com.mbobiosio.dbpractice.api.ApiService
import com.mbobiosio.dbpractice.model.Post

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class PostDataSource(
    private val apiService: ApiService
) : PagingSource<Int, Post>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return try {
            val nextPage = params.key ?: 1
            val response = loadPage(page = nextPage)

            LoadResult.Page(
                data = response,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (response.isNullOrEmpty()) null else nextPage + 1
            )
        } catch (t: Throwable) {
            LoadResult.Error(t)
        }
    }

    private suspend fun loadPage(
        page: Int?
    ): List<Post> {
        val response = apiService.getPosts(1, page)
        return response.results
    }
}