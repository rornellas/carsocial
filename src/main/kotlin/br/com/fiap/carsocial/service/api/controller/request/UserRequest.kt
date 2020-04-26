package br.com.fiap.carsocial.service.api.controller.request

import br.com.fiap.carsocial.service.api.document.User

data class UserRequest(
    var name: String?=null
) {
    fun convertToUser(): User {
        return User(null, name)
    }
}