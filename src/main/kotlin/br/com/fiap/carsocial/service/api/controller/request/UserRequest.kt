package br.com.fiap.carsocial.service.api.controller.request

import br.com.fiap.carsocial.service.api.document.User
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserRequest(
    @field:NotBlank
    var name: String?=null,
    @field:NotBlank
    @field:Email
    var email: String?=null,
    @field:NotBlank
    var telephone: String?=null,
    @field:NotBlank
    var password: String?=null

) {
    fun convertToUser(): User {
        return User(null, name = name, email = email, password = password)
    }
}