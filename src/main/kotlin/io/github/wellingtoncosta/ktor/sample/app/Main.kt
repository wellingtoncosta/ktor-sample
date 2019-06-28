package io.github.wellingtoncosta.ktor.sample.app

import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty

/**
 * @author Wellington Costa
 */

fun main(args: Array<String>) {
    embeddedServer(Jetty, commandLineEnvironment(args)).start()
}
