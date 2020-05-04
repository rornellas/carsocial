package br.com.fiap.carsocial.service.api.controller.response

import br.com.fiap.carsocial.service.api.document.Ride
import br.com.fiap.carsocial.service.api.model.Car

data class RideResponse(
        var id: String? = null,
        var name: String? = null,
        var email: String? = null,
        var car: Car?=null,
        var coords: CoordsResponse?=null
) {
    constructor(ride: Ride) : this() {
        this.id = ride.id
        this.name = ride.name
        this.email = ride.email
        this.car = ride.car
        this.coords = CoordsResponse(ride.coords?.x.toString(), ride.coords?.y.toString())
    }

}
