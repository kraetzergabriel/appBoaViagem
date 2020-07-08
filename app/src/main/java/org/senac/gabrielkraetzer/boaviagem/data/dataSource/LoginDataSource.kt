package org.senac.gabrielkraetzer.boaviagem.data.dataSource

import org.senac.gabrielkraetzer.boaviagem.data.Result
import org.senac.gabrielkraetzer.boaviagem.data.model.Login
import java.io.IOException

class LoginDataSource {

    fun login(username: String, password: String): Result<Login> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = Login(java.util.UUID.randomUUID().toString(), "Login")
            return Result.Success(
                fakeUser
            )
        } catch (e: Throwable) {
            return Result.Error(
                IOException("Erro ao efetuar o login", e)
            )
        }
    }

    fun logout() {

    }
}