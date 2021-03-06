package br.com.fiap.carsocial.service.api.controller

import br.com.fiap.carsocial.service.api.controller.request.CoordsRequest
import br.com.fiap.carsocial.service.api.controller.request.RideRequest
import br.com.fiap.carsocial.service.api.controller.response.RideResponse
import br.com.fiap.carsocial.service.api.controller.router.RideRouter
import br.com.fiap.carsocial.service.api.model.Greeting
import br.com.fiap.carsocial.service.api.service.IRideService
import io.swagger.annotations.ApiOperation
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid


@RestController
@RequestMapping("/rides")
class RideController(val rideService: IRideService) {

    @RequestMapping(RideRouter.GREETING)
    @ApiOperation(value = "Greetin API", hidden = true)
    fun greeting(): HttpEntity<Greeting> {
        val greeting = Greeting("Hello User!")
        greeting.add(linkTo(methodOn(RideController::class.java).greeting()).withSelfRel())
        greeting.add(linkTo(methodOn(RideController::class.java).create(RideRequest())).withRel("create"))
        greeting.add(linkTo(methodOn(RideController::class.java).findById("id_to_find")).withRel("findById"))
        greeting.add(linkTo(methodOn(RideController::class.java).search("sample_name", "sample_email", "sample_car_model")).withRel("search"))
        greeting.add(linkTo(methodOn(RideController::class.java).near("lat_position", "long_position", 5.0)).withRel("find_near"))
        greeting.add(linkTo(methodOn(RideController::class.java).updateCoords("id_to_update", CoordsRequest())).withRel("update_rider_lat_long"))

        return ResponseEntity<Greeting>(greeting, HttpStatus.OK)
    }

    @PostMapping(RideRouter.CREATE)
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody(required = true) rideRequest: RideRequest) : Mono<RideResponse> {
        return rideService.create(rideRequest)
    }

    @GetMapping(RideRouter.FIND_BY_ID)
    fun findById(@PathVariable(required = true) id: String) : Mono<RideResponse> {
        return rideService.findById(id)
    }

    @GetMapping(RideRouter.SEARCH)
    fun search(@RequestParam(required = false) name: String?, @RequestParam(required = false) email: String?, @RequestParam(required=false, value = "car_model") carModel: String?) : Flux<RideResponse> {
        return rideService.search(name, email, carModel)
    }

    @GetMapping(RideRouter.NEAR)
    fun near(@RequestParam(required = true) latitude: String, @RequestParam(required = true) longitude: String, @RequestParam(required = true, defaultValue = "5000") distance: Double) : Flux<RideResponse> {
        return rideService.near(latitude, longitude, distance)
    }

    @PatchMapping(RideRouter.NEW_COORDS)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCoords(@PathVariable(required = true) id: String, @RequestBody(required = true) coords: CoordsRequest) : Mono<RideResponse> {
        return rideService.updateCoords(id, coords)
    }

}