package com.mbobiosio.dbpractice.model

import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Follower(
    @Json(name = "ID")
    var id: Int?,

    @Json(name = "UserId")
    var userId: Int?,

    @Json(name = "FollowerId")
    var followerId: Int?,

    @Json(name = "UserViewModel")
    var followerData: UserData?,

    @Json(name = "FollowingStatus")
    var isFollowing: Boolean?,

    @Json(name = "NotificationToken")
    var notificationToken: String?
): Response