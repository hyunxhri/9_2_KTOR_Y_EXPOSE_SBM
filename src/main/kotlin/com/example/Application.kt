package com.example

import com.example.plugins.* // ktlint-disable no-wildcard-imports
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureTemplating()
    configureSerialization()
    configureDatabases()
    configureRouting()
}
