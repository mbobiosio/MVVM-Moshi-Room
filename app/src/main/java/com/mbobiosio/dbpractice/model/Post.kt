package com.mbobiosio.dbpractice.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Post(

    @Json(name = "ID")
    val id: Int?,

    @Json(name = "UserId")
    val userId: Int?,

    @Json(name = "Details")
    val details: String?,

    @Json(name = "Media")
    val media: String?,

    @Json(name = "Engagement")
    val engagement: Int?,

    @Json(name = "Reach")
    val reach: Int?,

    @Json(name = "Shares")
    val shares: Int?,

    @Json(name = "ProfileClicks")
    val profileClicks: Int?,

    @Json(name = "AddedDateAndTime")
    val addedDateAndTime: String?,

    @Json(name = "PostLikeCount")
    val postLikeCount: Int?,

    @Json(name = "PostCommentCount")
    val postCommentCount: Int?,

    @Json(name = "PostLikedBythisUser")
    val postLikedByThisUser: Boolean?,


    @Json(name = "UserViewModel")
    val userData: UserData?,

) : Response {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}