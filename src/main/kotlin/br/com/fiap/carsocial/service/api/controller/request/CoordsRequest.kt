package br.com.fiap.carsocial.service.api.controller.request

import org.springframework.data.mongodb.core.geo.GeoJsonPoint

data class CoordsRequest (
    var latitude: String?=null,
    var longitude: String?=null
) {
    fun convertToCoords(): GeoJsonPoint {
        return GeoJsonPoint(latitude?.toDouble()!!, longitude?.toDouble()!!)
    }
}