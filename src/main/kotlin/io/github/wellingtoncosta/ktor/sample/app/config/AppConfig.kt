package io.github.wellingtoncosta.ktor.sample.app.config

import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.SerializationFeature
import io.github.wellingtoncosta.ktor.sample.app.web.UserRouter
import io.github.wellingtoncosta.ktor.sample.domain.exception.UserNotFoundException
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.routing.Routing
import org.koin.Logger.SLF4JLogger
import org.koin.ktor.ext.Koin

/**
 * @author Wellington Costa
 */

fun Application.main() {
    install(StatusPages) { handleExceptions() }
    install(DefaultHeaders)
    install(Compression)
    install(CallLogging)
    install(Koin) {
        SLF4JLogger()
        modules(appModules)
    }
    install(Routing) { UserRouter.register(this) }
    install(ContentNegotiation) { configureJackson() }
}

internal fun StatusPages.Configuration.handleExceptions() {
    exception<UserNotFoundException> {
        call.respond(HttpStatusCode.NotFound)
    }
}

internal fun ContentNegotiation.Configuration.configureJackson() {
    jackson {
        configure(SerializationFeature.INDENT_OUTPUT, true)
        setDefaultPrettyPrinter(DefaultPrettyPrinter().apply {
            indentArraysWith(DefaultPrettyPrinter.FixedSpaceIndenter.instance)
            indentObjectsWith(DefaultIndenter("  ", "\n"))
        })
    }
}
