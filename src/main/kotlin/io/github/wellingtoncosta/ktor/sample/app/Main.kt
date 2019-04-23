package io.github.wellingtoncosta.ktor.sample.app

import io.github.wellingtoncosta.ktor.sample.app.config.appModules
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty
import org.koin.standalone.StandAloneContext.startKoin

/**
 * @author Wellington Costa
 */

fun main(args: Array<String>) {
    startKoin(appModules)

    embeddedServer(Jetty, commandLineEnvironment(args)).start()
}
