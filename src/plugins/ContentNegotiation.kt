package com.arifahmadalfian.plugins

import io.ktor.application.*
import io.ktor.features.*

fun Application.configureContentNegotiation() {
    install(ContentNegotiation) {

    }
}