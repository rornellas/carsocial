package br.com.fiap.carsocial.service.api.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @Id var id: String? =null,
    var name: String?=null,
    var password: String?=null,
    var email: String?=null,
    var telephone: String?=null
)