package org.senac.gabrielkraetzer.boaviagem.data.repository

import org.senac.gabrielkraetzer.boaviagem.data.Result
import org.senac.gabrielkraetzer.boaviagem.data.dataSource.LoginDataSource
import org.senac.gabrielkraetzer.boaviagem.data.model.Login

class LoginRepository(val dataSource: LoginDataSource) {

    var user: Login? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<Login> {
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(login: Login) {
        this.user = login
    }
}