package br.com.fiap.carsocial.service.api.service.impl

import br.com.fiap.carsocial.service.api.controller.request.CoordsRequest
import br.com.fiap.carsocial.service.api.controller.request.RideRequest
import br.com.fiap.carsocial.service.api.controller.response.RideResponse
import br.com.fiap.carsocial.service.api.document.Ride
import br.com.fiap.carsocial.service.api.model.Car
import br.com.fiap.carsocial.service.api.model.Coords
import br.com.fiap.carsocial.service.api.repository.IRideRepository
import br.com.fiap.carsocial.service.api.service.IRideService
import org.springframework.data.domain.Example
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Metric
import org.springframework.data.geo.Metrics
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class RideService(val rideRepository: IRideRepository): IRideService {

    override fun findById(id: String): Mono<RideResponse> {
        return rideRepository.findById(id).map { r -> RideResponse(r) }
    }

    override fun create(userRequest: RideRequest): Mono<RideResponse> {
        return rideRepository.save(userRequest.convertToRide()).map { r -> RideResponse(r) }
    }

    override fun search(name: String?, email: String?, carModel: String?): Flux<RideResponse> {
        val ride = Ride(name = name, email = email, car = Car(model = carModel))
        return rideRepository.findAll(Example.of(ride)).map { r -> RideResponse(r) }
    }

    override fun updateCoords(id: String, coords: CoordsRequest) {
        rideRepository.findById(id).doOnSuccess {
            it.coords = coords.convertToCoords()
            rideRepository.save(it)
        }
    }

    override fun near(latitude: String, longitude: String, distance: Double): Flux<RideResponse> {
        val convertedDistance = Distance(distance, Metrics.KILOMETERS)

        return rideRepository.near(latitude.toDouble(), longitude.toDouble(), convertedDistance.normalizedValue).map { r -> RideResponse(r) }
    }
}