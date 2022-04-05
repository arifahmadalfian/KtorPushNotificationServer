package com.arifahmadalfian

import com.arifahmadalfian.plugins.configureCallLogging
import com.arifahmadalfian.plugins.configureContentNegotiation
import com.arifahmadalfian.plugins.configureRouting
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.client.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    configureContentNegotiation()
    configureCallLogging()
    configureRouting()
}

