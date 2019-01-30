package io.github.wellingtoncosta.ktor.sample

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable data class Message(val message: String)

fun Message.toJson() = Json.stringify(Message.serializer(), this)

fun main() {
    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondText(Message("Hello, world!").toJson(), ContentType.Application.Json)
            }
        }
    }.start(wait = true)
}