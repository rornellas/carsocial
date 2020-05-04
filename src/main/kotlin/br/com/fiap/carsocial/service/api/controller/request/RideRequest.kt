package br.com.fiap.carsocial.service.api.controller.request

import br.com.fiap.carsocial.service.api.document.Ride
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class RideRequest(
    @field:NotBlank
    var name: String?=null,
    @field:NotBlank
    @field:Email
    var email: String?=null,
    @field:NotNull
    @field:Valid
    var car: CarRequest?=null,
    var coords: CoordsRequest?=null
) {
    fun convertToRide(): Ride {
        return Ride(id = null, name = name, email = email, car = car?.convertToCar(), coords = coords?.convertToCoords())
    }
}