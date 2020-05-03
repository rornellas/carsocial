package br.com.fiap.carsocial.service.api.document

import br.com.fiap.carsocial.service.api.model.Car
import br.com.fiap.carsocial.service.api.model.Coords
import com.mongodb.client.model.geojson.Point
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Ride(
    @Id var id: String? = null,
    var name: String? = null,
    var email: String? = null,
    var car: Car? = null,
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    var coords: GeoJsonPoint?=null
)