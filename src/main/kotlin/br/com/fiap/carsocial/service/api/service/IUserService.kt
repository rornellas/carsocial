package br.com.fiap.carsocial.service.api.service

import br.com.fiap.carsocial.service.api.controller.request.UserRequest
import br.com.fiap.carsocial.service.api.controller.response.UserResponse
import reactor.core.publisher.Mono

interface IUserService {

    fun create(userRequest: UserRequest): Mono<UserResponse>
    fun findById(id: String): Mono<UserResponse>
}
