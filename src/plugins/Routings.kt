package com.arifahmadalfian.plugins

import com.arifahmadalfian.data.remote.dto.IOneSignalService
import com.arifahmadalfian.data.remote.dto.Notification
import com.arifahmadalfian.data.remote.dto.NotificationMessage
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting(service: IOneSignalService) {

    routing {
        get("/sendNotification") {
            val title = call.parameters["title"] ?: "test"
            val description = call.parameters["description"] ?: "test"

            val successful = service.sendNotification(
                Notification(
                    includeSegments = listOf("All"),
                    heading = NotificationMessage(en = title),
                    content = NotificationMessage(en = description),
                    appId = IOneSignalService.ONESIGNAL_APP_ID
                )
            )
            if (successful) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(HttpStatusCode.InternalServerError)
            }
        }
    }
}