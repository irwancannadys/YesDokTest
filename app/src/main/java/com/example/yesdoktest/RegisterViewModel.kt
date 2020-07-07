package com.example.yesdoktest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    var email: String = ""
    var firstname: String = ""
    var lastname: String = ""
    var phone: String = ""
    var password: String = ""

    private val registerResult = MutableLiveData<String>()
    fun getLogInResult(): LiveData<String> = registerResult

    fun performValidation() {

        if (email.isBlank()) {
            registerResult.value = "Invalid username"
            return
        }

        if (firstname.isBlank()) {
            registerResult.value = "Invalid firstname"
            return
        }

        if (lastname.isBlank()) {
            registerResult.value = "Invalid lastname"
            return
        }

        if (phone.isBlank()) {
            registerResult.value = "Invalid phone"
            return
        }

        if (password.isBlank()) {
            registerResult.value = "Invalid password"
            return
        }

        if (password.length < 8) {
            registerResult.value = "password must be 8 characters"
        }

        registerResult.value = "Register success :)"
    }
}