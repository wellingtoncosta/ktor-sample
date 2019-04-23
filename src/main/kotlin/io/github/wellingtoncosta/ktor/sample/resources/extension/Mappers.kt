package io.github.wellingtoncosta.ktor.sample.resources.extension

import io.github.wellingtoncosta.ktor.sample.domain.entity.User
import io.github.wellingtoncosta.ktor.sample.resources.entity.UserTable
import org.jetbrains.exposed.sql.ResultRow

/**
 * @author Wellington Costa
 */

fun ResultRow.toUserDomain() = User(
    id = this[UserTable.id],
    name = this[UserTable.name],
    email = this[UserTable.email],
    phone = this[UserTable.phone]
)
