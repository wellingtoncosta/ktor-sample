package io.github.wellingtoncosta.ktor.sample.domain.exception

import java.lang.RuntimeException

/**
 * @author Wellington Costa
 */
class UserNotFoundException(id: Long) : RuntimeException("User with identifier $id was not found.")