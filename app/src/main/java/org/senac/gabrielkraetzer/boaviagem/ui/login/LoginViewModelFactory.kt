package org.senac.gabrielkraetzer.boaviagem.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.senac.gabrielkraetzer.boaviagem.data.dao.LoginDao
import org.senac.gabrielkraetzer.boaviagem.data.repository.LoginRepository

class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                    loginRepository = LoginRepository(
                        dao = LoginDao()
                    )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}