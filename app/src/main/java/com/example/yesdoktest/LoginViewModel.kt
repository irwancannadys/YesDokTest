package com.example.yesdoktest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    var username: String = ""
    var password: String = ""
    private val logInResult = MutableLiveData<String>()
    fun getLogInResult(): LiveData<String> = logInResult

    fun performValidation() {

        if (username.isBlank()) {
            logInResult.value = "Invalid username"
            return
        }

        if (password.isBlank()) {
            logInResult.value = "Invalid password"
            return
        }

        logInResult.value = "Valid credentials :)"
    }
}