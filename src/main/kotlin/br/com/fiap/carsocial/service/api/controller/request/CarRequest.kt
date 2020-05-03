package br.com.fiap.carsocial.service.api.controller.request

import br.com.fiap.carsocial.service.api.document.User
import br.com.fiap.carsocial.service.api.model.Car
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class CarRequest(
    @field:NotBlank
    var model: String?=null,
    @field:NotBlank
    var plate: String?=null

) {
    fun convertToCar(): Car {
        return Car(model = model, plate = plate)
    }
}