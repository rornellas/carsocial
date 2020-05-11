package br.com.fiap.carsocial.service.api.controller.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class NotFoundException(s: String) : RuntimeException(s) {

}