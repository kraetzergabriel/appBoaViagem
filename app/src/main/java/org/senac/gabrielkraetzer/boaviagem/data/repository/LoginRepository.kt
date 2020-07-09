package org.senac.gabrielkraetzer.boaviagem.data.repository

import org.senac.gabrielkraetzer.boaviagem.data.Result
import org.senac.gabrielkraetzer.boaviagem.data.Dao.LoginDao
import org.senac.gabrielkraetzer.boaviagem.data.model.Login

class LoginRepository(val dao: LoginDao) {

    var user: Login? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
        dao.logout()
    }

    fun login(username: String, password: String): Result<Login> {
        val result = dao.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(login: Login) {
        this.user = login
    }
}