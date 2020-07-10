package org.senac.gabrielkraetzer.boaviagem.data.dao

import org.senac.gabrielkraetzer.boaviagem.data.Result
import org.senac.gabrielkraetzer.boaviagem.data.model.Login
import java.io.IOException

class LoginDao {

    fun login(username: String, password: String): Result<Login> {
        try {
            val fakeUser = Login(password, username)
            return Result.Success(
                fakeUser
            )
        } catch (e: Throwable) {
            return Result.Error(
                IOException("Erro ao efetuar o login", e)
            )
        }
    }

    fun logout() : Result<Login>{
        try{
            var fakeuser = Login("", "")
            return Result.Success(
                fakeuser
            )
        } catch (e: Throwable) {
            return Result.Error(
                IOException("Erro ao efetuar o logout")
            )
        }
    }
}