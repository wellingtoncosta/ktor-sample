package io.github.wellingtoncosta.ktor.sample.domain.repository

import io.github.wellingtoncosta.ktor.sample.domain.entity.User

/**
 * @author Wellington Costa
 */
interface UserRepository {

    fun getAll(): List<User>

    fun getOne(id: Long): User

    fun create(user: User): User

    fun update(id: Long, user: User): User

    fun delete(id: Long)

}