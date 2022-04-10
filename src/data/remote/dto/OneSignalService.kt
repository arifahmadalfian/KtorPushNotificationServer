package com.arifahmadalfian.data.remote.dto

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class OneSignalService(
    private val client: HttpClient,
    private val apiKey: String
) : IOneSignalService {
    override suspend fun sendNotification(notification: Notification): Boolean {
        return try {
            client.post<String> {
                url(IOneSignalService.NOTIFICATION)
                contentType(ContentType.Application.Json)
                header("Authorization", "Basic $apiKey")
                body = notification
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}