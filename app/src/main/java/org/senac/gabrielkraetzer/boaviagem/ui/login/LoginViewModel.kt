package org.senac.gabrielkraetzer.boaviagem.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.senac.gabrielkraetzer.boaviagem.data.repository.LoginRepository
import org.senac.gabrielkraetzer.boaviagem.data.Result

import org.senac.gabrielkraetzer.boaviagem.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) : Boolean {
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value = LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
            return true
        } else {
            _loginResult.value = LoginResult(error = R.string.falha_login)
            return false
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.toString().isNotEmpty()
    }
}