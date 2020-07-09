package org.senac.gabrielkraetzer.boaviagem.data.Dao

import org.senac.gabrielkraetzer.boaviagem.data.Result
import org.senac.gabrielkraetzer.boaviagem.data.model.Login
import java.io.IOException

class LoginDao {

    fun login(username: String, password: String): Result<Login> {
        try {

            val fakeUser = Login("", "Login")
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