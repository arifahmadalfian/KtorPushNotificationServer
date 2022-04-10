package com.arifahmadalfian

import com.arifahmadalfian.data.remote.dto.OneSignalService
import com.arifahmadalfian.plugins.configureCallLogging
import com.arifahmadalfian.plugins.configureContentNegotiation
import com.arifahmadalfian.plugins.configureRouting
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    configureContentNegotiation()
    configureCallLogging()
    val client = HttpClient(CIO)
    val apiKey = environment.config.property("onesignal.api_key").toString()
    val service = OneSignalService(client = client, apiKey = apiKey)
    configureRouting(service = service)
}

