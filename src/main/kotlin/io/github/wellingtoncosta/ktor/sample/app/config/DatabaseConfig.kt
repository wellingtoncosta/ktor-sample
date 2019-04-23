package io.github.wellingtoncosta.ktor.sample.app.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource

/**
 * @author Wellington Costa
 */

const val jdbcUrl = "jdbc:postgresql://localhost:5432/usersdb"
const val jdbcDriver = "org.postgresql.Driver"
const val dbUsername = "postgres"
const val dbPassword = "postgres"

class DatabaseConfig(jdbcUrl: String, driverClassName: String, username: String, password: String) {

    val dataSource: DataSource

    init {
        dataSource = HikariConfig().apply {
            this.jdbcUrl = jdbcUrl
            this.username = username
            this.password = password
            this.driverClassName = driverClassName
        }.let { HikariDataSource(it) }
    }

}