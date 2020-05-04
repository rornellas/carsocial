package br.com.fiap.carsocial.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux


@SpringBootApplication
class ServiceApplication {

}

fun main(args: Array<String>) {
	runApplication<ServiceApplication>(*args)
}
