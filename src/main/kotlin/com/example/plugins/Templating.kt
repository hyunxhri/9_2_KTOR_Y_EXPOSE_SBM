package com.example.plugins

import freemarker.cache.*
import freemarker.core.HTMLOutputFormat
import io.ktor.server.application.* // ktlint-disable no-wildcard-imports
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureTemplating() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        outputFormat = HTMLOutputFormat.INSTANCE
    }
    routing {
        get("/html-freemarker") {
            call.respond(FreeMarkerContent("indexArticle.ftl", mapOf("data" to IndexData(listOf(1, 2, 3))), ""))
        }
    }
}

