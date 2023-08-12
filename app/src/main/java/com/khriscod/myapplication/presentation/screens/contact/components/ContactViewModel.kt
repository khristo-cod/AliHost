package com.khriscod.myapplication.presentation.screens.contact.components

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(): ViewModel() {

    //USERNAME
    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrMsg: MutableState<String> = mutableStateOf("")

    //EMAIL
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    //PHONE
    var phone: MutableState<String> = mutableStateOf("")
    var isPhoneValid: MutableState<Boolean> = mutableStateOf(false)
    var phoneErrMsg: MutableState<String> = mutableStateOf("")

    //ADDRESS
    var address: MutableState<String> = mutableStateOf("")
    var isAddressValid: MutableState<Boolean> = mutableStateOf(false)
    var addressErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledContactButton = false

    fun enabledContactButtom(){
        isEnabledContactButton = (isUsernameValid.value && isEmailValid.value && isPhoneValid.value && isAddressValid.value)
    }

    fun validateUsername (){
        if (username.value.length>4){
            isUsernameValid.value=true
            usernameErrMsg.value=""
        }else{
            isUsernameValid.value=false
            usernameErrMsg.value = "Nombre, debe contener al menos 6 caracteres"
        }
        enabledContactButtom()
    }

    fun validateEmail (){
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            isEmailValid.value=true
            emailErrMsg.value=""
        }else{
            isEmailValid.value=false
            emailErrMsg.value = "Correo, no valido"
        }
        enabledContactButtom()
    }

    fun validatePhone (){
        if (Patterns.PHONE.matcher(phone.value).matches()){
            isPhoneValid.value=true
            phoneErrMsg.value=""
        }else{
            isPhoneValid.value=false
            phoneErrMsg.value = "Celular, debe contener 10 caracteres"
        }
        enabledContactButtom()
    }

    fun validateAddress (){
        if (address.value.length>6){
            isAddressValid.value=true
            addressErrMsg.value=""
        }else{
            isAddressValid.value=false
            addressErrMsg.value = "Direccion, debe contener al menos 6 caracteres"
        }
        enabledContactButtom()
    }
}