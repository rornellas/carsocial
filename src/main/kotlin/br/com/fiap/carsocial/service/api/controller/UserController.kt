package br.com.fiap.carsocial.service.api.controller

import br.com.fiap.carsocial.service.api.controller.request.UserRequest
import br.com.fiap.carsocial.service.api.controller.response.UserResponse
import br.com.fiap.carsocial.service.api.controller.router.UserRouter
import br.com.fiap.carsocial.service.api.service.IUserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserController(val userService: IUserService) {

    @PostMapping(UserRouter.CREATE)
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody(required = true) userRequest: UserRequest) : Mono<UserResponse> {
        return userService.create(userRequest)
    }

    @GetMapping(UserRouter.FIND_BY_ID)
    fun findById(@PathVariable(required = true) id: String) : Mono<UserResponse> {
        return userService.findById(id)
    }

}