package com.mbobiosio.dbpractice.listener

import com.mbobiosio.dbpractice.model.Follower

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
interface UserListener {
    fun onItemClicked(user: Follower)
}