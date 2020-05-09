package br.com.fiap.carsocial.service.api.service

import br.com.fiap.carsocial.service.api.controller.request.TravelRequest
import br.com.fiap.carsocial.service.api.controller.response.TravelResponse
import reactor.core.publisher.Mono

interface ITravelService {
    fun create(travelRequest: TravelRequest): Mono<TravelResponse>
    fun findById(id: String): Mono<TravelResponse>
    fun start(id: String): Mono<TravelResponse>
    fun finish(id: String): Mono<TravelResponse>
}
