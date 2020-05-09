package br.com.fiap.carsocial.service.api.document

import br.com.fiap.carsocial.service.api.controller.request.CoordsRequest
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document
data class Travel (
    @Id
    var id: String?=null,
    var userId: String?=null,
    var rideId: String?=null,
    var originCoords: CoordsRequest?=null,
    var destinyCoords: CoordsRequest?=null,
    var requestedAt: LocalDateTime?=null,
    var startedAt: LocalDateTime?=null,
    var finishedAt: LocalDateTime?=null
)
