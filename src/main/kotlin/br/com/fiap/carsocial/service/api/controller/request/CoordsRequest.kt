package br.com.fiap.carsocial.service.api.controller.request

import br.com.fiap.carsocial.service.api.controller.exception.ValidationException
import org.springframework.data.mongodb.core.geo.GeoJsonPoint

data class CoordsRequest (
    var latitude: String?=null,
    var longitude: String?=null
) {
    fun convertToCoords(): GeoJsonPoint {

        try {
            val geoJsonPoint = GeoJsonPoint(latitude?.toDouble()!!, longitude?.toDouble()!!)

            if(geoJsonPoint.x < -90 || geoJsonPoint.x > 90
                    || geoJsonPoint.y < -180 || geoJsonPoint.y > 180
            )
                throw RuntimeException()

            return geoJsonPoint
        } catch (e: Throwable) {
            throw ValidationException("Invalid latitude/longitude")
        }
    }
}