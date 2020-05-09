package br.com.fiap.carsocial.service.api.controller.response

import br.com.fiap.carsocial.service.api.controller.request.CoordsRequest
import br.com.fiap.carsocial.service.api.document.Travel
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.*

data class TravelResponse(
    var id: String?=null,
    @JsonProperty("user_id")
    var userId: String?=null,
    @JsonProperty("ride_id")
    var rideId: String?=null,
    @JsonProperty("origin_coords")
    var originCoords: CoordsRequest?=null,
    @JsonProperty("destiny_coords")
    var destinyCoords: CoordsRequest?=null,
    @JsonProperty("requested_at")
    var requestedAt: LocalDateTime?=null,
    @JsonProperty("started_at")
    var startedAt: LocalDateTime?=null,
    @JsonProperty("finished_at")
    var finishedAt: LocalDateTime?=null
) {
    constructor(travel: Travel) : this() {
        this.id = travel.id
        this.userId = travel.userId
        this.rideId = travel.rideId
        this.originCoords = travel.originCoords
        this.destinyCoords = travel.destinyCoords
        this.requestedAt = travel.requestedAt
        this.startedAt = travel.startedAt
        this.finishedAt = travel.finishedAt
    }
}
