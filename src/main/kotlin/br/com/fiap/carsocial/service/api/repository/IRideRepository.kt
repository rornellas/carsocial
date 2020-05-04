package br.com.fiap.carsocial.service.api.repository

import br.com.fiap.carsocial.service.api.document.Ride
import org.springframework.data.domain.Example
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface IRideRepository: ReactiveCrudRepository<Ride, String> {
    fun findAll(example: Example<Ride>): Flux<Ride>

    @Query(value = "{\"coords\":{ \$near :{\$geometry : {type : \"Point\" ,coordinates : [?0, ?1] }, \$maxDistance:?2} } }\"\"")
    fun near(longitude: Double, latitude: Double, distance: Double): Flux<Ride>
}