package io.github.wellingtoncosta.ktor.sample.app.config

import io.github.wellingtoncosta.ktor.sample.domain.repository.UserRepository
import io.github.wellingtoncosta.ktor.sample.domain.service.UserService
import io.github.wellingtoncosta.ktor.sample.resources.repository.UserDatabaseRepository
import org.koin.dsl.module

/**
 * @author Wellington Costa
 */

val configModule = module {
    single { DatabaseConfig(jdbcUrl, jdbcDriver, dbUsername, dbPassword).dataSource }
}

val userModule = module {
    single { UserDatabaseRepository(get()) as UserRepository }
    single { UserService(get()) }
}

val appModules = listOf(configModule, userModule)