package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    //Add the five lines below
    install(StatusPages) {
        exception<IllegalStateException> { call, cause ->
            call.respondText("App in illegal state as ${cause.message}")
        }
    }

    routing {
        // Add the line below
        staticResources("/content", "mycontent")


        get("/") {
            call.respondText("Hello World!")
        }

        post("/abc") {
            call.respondText("Hello World222!")
        }

        // Add the five lines below
        get("/test1") {
            val text = "<h1>Hello From Ktor</h1>"
            val type = ContentType.parse("text/html")
            call.respondText(text, type)
        }

        //Add the three lines below
        get("/error-test") {
            throw IllegalStateException("Too Busy")
        }
    }
}
