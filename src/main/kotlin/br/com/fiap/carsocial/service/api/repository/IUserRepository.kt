package br.com.fiap.carsocial.service.api.repository

import br.com.fiap.carsocial.service.api.document.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserRepository: ReactiveCrudRepository<User, String> {

}