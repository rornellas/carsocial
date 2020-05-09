package br.com.fiap.carsocial.service.api.controller

import br.com.fiap.carsocial.service.api.controller.request.CoordsRequest
import br.com.fiap.carsocial.service.api.controller.request.TravelRequest
import br.com.fiap.carsocial.service.api.controller.response.TravelResponse
import br.com.fiap.carsocial.service.api.controller.router.RideRouter
import br.com.fiap.carsocial.service.api.controller.router.TravelRouter
import br.com.fiap.carsocial.service.api.model.Greeting
import br.com.fiap.carsocial.service.api.service.ITravelService
import io.swagger.annotations.ApiOperation
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
@RequestMapping("/travels")
class TravelController(val travelService: ITravelService) {

    @RequestMapping(TravelRouter.GREETING)
    @ApiOperation(value = "Greetin API", hidden = true)
    fun greeting(): HttpEntity<Greeting> {
        val greeting = Greeting("Hello User!")
        greeting.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TravelController::class.java).greeting()).withSelfRel())
        greeting.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TravelController::class.java).create(TravelRequest())).withRel("create"))
        greeting.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TravelController::class.java).findById("id_to_find")).withRel("findById"))
        greeting.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TravelController::class.java).start("id_to_start")).withRel("startTravel"))
        greeting.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TravelController::class.java).finish("id_to_finish")).withRel("finishTravel"))

        return ResponseEntity<Greeting>(greeting, HttpStatus.OK)
    }

    @PostMapping(TravelRouter.CREATE)
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody(required = true) travelRequest: TravelRequest) : Mono<TravelResponse> {
        return travelService.create(travelRequest)
    }

    @GetMapping(TravelRouter.FIND_BY_ID)
    fun findById(@PathVariable(required = true) id: String) : Mono<TravelResponse> {
        return travelService.findById(id)
    }

    @PatchMapping(TravelRouter.START)
    @ResponseStatus(HttpStatus.OK)
    fun start(@PathVariable(required = true) id: String) : Mono<TravelResponse>  {
        return travelService.start(id)
    }

    @PatchMapping(TravelRouter.FINISH)
    @ResponseStatus(HttpStatus.OK)
    fun finish(@PathVariable(required = true) id: String) : Mono<TravelResponse>  {
        return travelService.finish(id)
    }
}