package br.com.fiap.carsocial.service.api.service.impl

import br.com.fiap.carsocial.service.api.controller.exception.NotFoundException
import br.com.fiap.carsocial.service.api.controller.request.CoordsRequest
import br.com.fiap.carsocial.service.api.controller.request.RideRequest
import br.com.fiap.carsocial.service.api.controller.response.RideResponse
import br.com.fiap.carsocial.service.api.document.Ride
import br.com.fiap.carsocial.service.api.model.Car
import br.com.fiap.carsocial.service.api.repository.IRideRepository
import br.com.fiap.carsocial.service.api.service.IRideService
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class RideService(val rideRepository: IRideRepository): IRideService {

    override fun findById(id: String): Mono<RideResponse> {
        return rideRepository.findById(id).switchIfEmpty(Mono.error(NotFoundException("Ride not found!"))).map { r -> RideResponse(r) }
    }

    override fun create(userRequest: RideRequest): Mono<RideResponse> {
        return rideRepository.save(userRequest.convertToRide()).map { r -> RideResponse(r) }
    }

    override fun search(name: String?, email: String?, carModel: String?): Flux<RideResponse> {
        val ride = Ride(name = name, email = email, car = Car(model = carModel))
        return rideRepository.findAll(Example.of(ride)).map { r -> RideResponse(r) }
    }

    override fun updateCoords(id: String, coords: CoordsRequest): Mono<RideResponse> {
        return rideRepository.findById(id).switchIfEmpty(Mono.error(NotFoundException("Ride not found!"))).doOnSuccess{
            it.coords = coords.convertToCoords()
            rideRepository.save(it)
        }.map { r -> RideResponse(r) }
    }

    override fun near(latitude: String, longitude: String, distance: Double): Flux<RideResponse> {
        val coords = CoordsRequest(latitude, longitude).convertToCoords()
        return rideRepository.near(coords.x, coords.y, distance).map { r -> RideResponse(r) }
    }
}