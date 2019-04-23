package io.github.wellingtoncosta.ktor.sample.domain.service

import io.github.wellingtoncosta.ktor.sample.domain.repository.UserRepository
import io.github.wellingtoncosta.ktor.sample.domain.entity.User

/**
 * @author Wellington Costa
 */
class UserService(private val repository: UserRepository) {

    fun getAll() = repository.getAll()

    fun getOne(id: Long) = repository.getOne(id)

    fun create(user: User) = repository.create(user)

    fun update(id: Long, user: User) = repository.update(id, user)

    fun delete(id: Long) = repository.delete(id)

}