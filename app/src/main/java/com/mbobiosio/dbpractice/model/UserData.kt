package com.mbobiosio.dbpractice.model

import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class UserData(
    @Json(name = "UserName")
    var userName: String?,

    @Json(name = "ProfilePhoto")
    var profilePhoto: String?,

    @Json(name = "FullName")
    var fullName: String?,

    @Json(name = "NotificationToken")
    var notificationToken: String?
): Response