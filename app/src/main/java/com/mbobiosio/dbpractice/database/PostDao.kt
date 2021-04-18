package com.mbobiosio.dbpractice.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mbobiosio.dbpractice.model.Post

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
@Dao
interface PostDao {
    @Insert
    suspend fun insertAll(vararg post: Post): List<Long>

    @Query("SELECT * FROM posts")
    suspend fun getAllPosts(): List<Post>

    @Query("SELECT * FROM posts WHERE uuid = :postId")
    suspend fun getPost(postId: Int): Post

    @Query("DELETE FROM posts")
    suspend fun deleteAllPosts()
}