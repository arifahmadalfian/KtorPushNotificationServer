package com.arifahmadalfian.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Notification(
//    @SerialName("included_external_user_ids")
//    val includeExternalUserIds: List<String>,
    @SerialName("included_segments")
    val includeSegments: List<String>,
    val content: NotificationMessage,
    val heading: NotificationMessage,
    @SerialName("app_id")
    val appId: String
)