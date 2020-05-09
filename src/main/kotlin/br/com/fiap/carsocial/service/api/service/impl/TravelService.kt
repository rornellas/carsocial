package br.com.fiap.carsocial.service.api.service.impl

import br.com.fiap.carsocial.service.api.controller.request.CoordsRequest
import br.com.fiap.carsocial.service.api.controller.request.TravelRequest
import br.com.fiap.carsocial.service.api.controller.response.TravelResponse
import br.com.fiap.carsocial.service.api.document.Ride
import br.com.fiap.carsocial.service.api.document.Travel
import br.com.fiap.carsocial.service.api.repository.ITravelRepository
import br.com.fiap.carsocial.service.api.service.ITravelService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Service
class TravelService(val travelRepository: ITravelRepository, val userService: UserService, val rideService: RideService): ITravelService {

    override fun findById(id: String): Mono<TravelResponse> {
        return travelRepository.findById(id).map { t -> TravelResponse(t) }
    }

    override fun create(travelRequest: TravelRequest): Mono<TravelResponse> {
        var travel: Travel = travelRequest.convertToTravel()
        travel.requestedAt = LocalDateTime.now()
        return travelRepository.save(travel).map { t -> TravelResponse(t) }
    }

    override fun start(id: String): Mono<TravelResponse> {
        return travelRepository.findById(id).map{
            it.startedAt = LocalDateTime.now()
            travelRepository.save(it).subscribe()
            TravelResponse(it)
        }
    }
    override fun finish(id: String): Mono<TravelResponse> {
        return travelRepository.findById(id).map {
            it.finishedAt = LocalDateTime.now()
            travelRepository.save(it).subscribe()
            TravelResponse(it)
        }

    }
}