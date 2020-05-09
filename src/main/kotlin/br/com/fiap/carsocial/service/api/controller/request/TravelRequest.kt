package br.com.fiap.carsocial.service.api.controller.request

import br.com.fiap.carsocial.service.api.document.Travel
import com.fasterxml.jackson.annotation.JsonProperty

data class TravelRequest(
    @JsonProperty("user_id")
    var userId: String?=null,
    @JsonProperty("ride_id")
    var rideId: String?=null,
    @JsonProperty("origin_coords")
    var originCoords: CoordsRequest?=null,
    @JsonProperty("destiny_coords")
    var destinyCoords: CoordsRequest?=null
) {
    fun convertToTravel(): Travel {
        return Travel(userId = userId,rideId = rideId, originCoords = originCoords, destinyCoords = destinyCoords)
    }
}