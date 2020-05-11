package br.com.fiap.carsocial.service.api.controller.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class ValidationException(s: String) : RuntimeException(s) {

}