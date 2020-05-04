package br.com.fiap.carsocial.service.api.controller

import br.com.fiap.carsocial.service.api.controller.request.UserRequest
import br.com.fiap.carsocial.service.api.controller.response.UserResponse
import br.com.fiap.carsocial.service.api.controller.router.UserRouter
import br.com.fiap.carsocial.service.api.model.Greeting
import br.com.fiap.carsocial.service.api.service.IUserService
import io.swagger.annotations.ApiOperation
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(val userService: IUserService) {

    @RequestMapping(UserRouter.GREETING)
    @ApiOperation(value = "Greetin API", hidden = true)
    fun greeting(): HttpEntity<Greeting> {
        val greeting = Greeting("Hello User!")
        greeting.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController::class.java).greeting()).withSelfRel())
        greeting.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController::class.java).create(UserRequest())).withRel("create"))
        greeting.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController::class.java).findById("id_to_find")).withRel("findById"))

        return ResponseEntity<Greeting>(greeting, HttpStatus.OK)
    }

    @PostMapping(UserRouter.CREATE)
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody(required = true) userRequest: UserRequest) : Mono<UserResponse> {
        return userService.create(userRequest)
    }

    @GetMapping(UserRouter.FIND_BY_ID)
    fun findById(@PathVariable(required = true) id: String) : Mono<UserResponse> {
        return userService.findById(id)
    }

}