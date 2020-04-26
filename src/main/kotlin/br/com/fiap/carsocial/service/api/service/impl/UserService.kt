package br.com.fiap.carsocial.service.api.service.impl

import br.com.fiap.carsocial.service.api.controller.request.UserRequest
import br.com.fiap.carsocial.service.api.controller.response.UserResponse
import br.com.fiap.carsocial.service.api.repository.IUserRepository
import br.com.fiap.carsocial.service.api.service.IUserService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(val userRepository: IUserRepository): IUserService {

    override fun findById(id: String): Mono<UserResponse> {
        return userRepository.findById(id).map { u -> UserResponse(u) }
    }

    override fun create(userRequest: UserRequest): Mono<UserResponse> {
        return userRepository.save(userRequest.convertToUser()).map { u -> UserResponse(u) }
    }
}