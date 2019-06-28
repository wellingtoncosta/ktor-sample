package io.github.wellingtoncosta.ktor.sample.app.web

import io.github.wellingtoncosta.ktor.sample.domain.service.UserService
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import org.koin.core.KoinComponent
import org.koin.core.get

/**
 * @author Wellington Costa
 */
object UserRouter : KoinComponent {

    private val userService = get<UserService>()

    fun register(routing: Routing) {
        routing.apply {
            route("/users") {
                get {
                    call.respond(userService.getAll())
                }
                get("/{id}") {
                    call.respond(userService.getOne(call.getIdFromParams()))
                }
                post {
                    call.respond(call.receive()) // TODO
                }
                put("/{id}") {
                    call.respond(userService.update(call.getIdFromParams(), call.receive()))
                }
                delete("/{id}") {
                    call.respond(userService.delete(call.getIdFromParams()))
                }
            }
        }
    }

    private fun ApplicationCall.getIdFromParams() = parameters["id"]?.toLong() ?: 0L

}
