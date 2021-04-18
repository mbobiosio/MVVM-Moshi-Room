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
@Entity(tableName = "posts")
data class Post(

    @ColumnInfo(name = "post_id")
    @Json(name = "ID")
    val id: Int?,

    @ColumnInfo(name = "user_id")
    @Json(name = "UserId")
    val userId: Int?,

    @ColumnInfo(name = "content")
    @Json(name = "Details")
    val details: String?,

    @ColumnInfo(name = "media")
    @Json(name = "Media")
    val media: String?,

    @ColumnInfo(name = "engagements")
    @Json(name = "Engagement")
    val engagement: Int?,

    @ColumnInfo(name = "reach")
    @Json(name = "Reach")
    val reach: Int?,

    @ColumnInfo(name = "share")
    @Json(name = "Shares")
    val shares: Int?,

    @ColumnInfo(name = "profile_clicks")
    @Json(name = "ProfileClicks")
    val profileClicks: Int?,

    @ColumnInfo(name = "created_at")
    @Json(name = "AddedDateAndTime")
    val addedDateAndTime: String?,

    @ColumnInfo(name = "likes_count")
    @Json(name = "PostLikeCount")
    val postLikeCount: Int?,

    @ColumnInfo(name = "comments_count")
    @Json(name = "PostCommentCount")
    val postCommentCount: Int?,

    @ColumnInfo(name = "isLiked")
    @Json(name = "PostLikedBythisUser")
    val postLikedByThisUser: Boolean?

) : Response {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}