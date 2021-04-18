package com.mbobiosio.dbpractice.listener

import com.mbobiosio.dbpractice.model.Post

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
interface PostListener {
    fun onItemClicked(post: Post)
}