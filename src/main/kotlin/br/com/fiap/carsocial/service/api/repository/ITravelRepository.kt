package br.com.fiap.carsocial.service.api.repository

import br.com.fiap.carsocial.service.api.document.Travel
import br.com.fiap.carsocial.service.api.document.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ITravelRepository: ReactiveCrudRepository<Travel, String> {

}