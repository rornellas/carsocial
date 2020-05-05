package br.com.fiap.carsocial.service.api.controller.response

import br.com.fiap.carsocial.service.api.document.User

data class UserResponse(
    var id: String? = null,
    var name: String? = null,
    var email: String? = null,
    var telephone: String?=null
) {
    constructor(user: User) : this() {
        this.id = user.id
        this.name = user.name
        this.email = user.email
        this.telephone = user.telephone
    }

}
