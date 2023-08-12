package com.khriscod.myapplication.presentation.screens.login.components

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.khriscod.myapplication.domain.model.Response
import com.khriscod.myapplication.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases):ViewModel() {


    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    var password:MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledLoginButton = false

    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> = _loginFlow


    fun login() = viewModelScope.launch {
        _loginFlow.value = Response.Loading
        val result = authUseCases.login(email.value, password.value)
        _loginFlow.value = result
    }

    fun enabledLoginButtom(){
        isEnabledLoginButton = isEmailValid.value && isPasswordValid.value
    }

    fun validateEmail (){
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            isEmailValid.value=true
            emailErrMsg.value=""
        }else{
            isEmailValid.value=false
            emailErrMsg.value = "Correo, no valido"
        }
        enabledLoginButtom()
    }

    fun validatePassword (){
        if (password.value.length>=6){
            isPasswordValid.value=true
            passwordErrMsg.value=""
        }else{
            isPasswordValid.value=false
            passwordErrMsg.value = "Password, debe contener al menos 6 caracteres"
        }
        enabledLoginButtom()
    }
}

