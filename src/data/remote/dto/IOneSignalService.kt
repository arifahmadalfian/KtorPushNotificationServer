package com.arifahmadalfian.data.remote.dto

interface IOneSignalService {
    suspend fun sendNotification(notification: Notification): Boolean

    companion object {
        const val ONESIGNAL_APP_ID = "00dfe927-032d-4a93-a676-6664bd517150"
        const val NOTIFICATION = "https://onesignal.com/api/v1/notifications"
    }
}