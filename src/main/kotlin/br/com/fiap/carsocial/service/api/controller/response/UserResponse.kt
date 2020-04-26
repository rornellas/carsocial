package br.com.fiap.carsocial.service.api.controller.response

import br.com.fiap.carsocial.service.api.document.User

data class UserResponse(
    var id: String? = null,
    var name: String? = null
) {
    constructor(user: User) : this() {
        this.id = user.id
        this.name = user.name
    }

}
