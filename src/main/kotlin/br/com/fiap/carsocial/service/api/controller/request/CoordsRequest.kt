package br.com.fiap.carsocial.service.api.controller.request

import br.com.fiap.carsocial.service.api.model.Car
import br.com.fiap.carsocial.service.api.model.Coords
import com.mongodb.client.model.geojson.Point
import com.mongodb.client.model.geojson.Position
import org.springframework.data.mongodb.core.geo.GeoJsonPoint

data class CoordsRequest (
    var latitude: String?=null,
    var longitude: String?=null
) {
    fun convertToCoords(): GeoJsonPoint {
        return GeoJsonPoint(latitude?.toDouble()!!, longitude?.toDouble()!!)
    }
}