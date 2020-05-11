package br.com.fiap.carsocial.service.api.service

import br.com.fiap.carsocial.service.api.controller.request.CoordsRequest
import br.com.fiap.carsocial.service.api.controller.request.RideRequest
import br.com.fiap.carsocial.service.api.controller.response.RideResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IRideService {

    fun create(userRequest: RideRequest): Mono<RideResponse>
    fun findById(id: String): Mono<RideResponse>
    fun search(name: String?, email: String?, carModel: String?): Flux<RideResponse>
    fun updateCoords(id: String, coords: CoordsRequest): Mono<RideResponse>
    fun near(latitude: String, longitude: String, distance: Double): Flux<RideResponse>
}
