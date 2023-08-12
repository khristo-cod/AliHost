package com.khriscod.myapplication.presentation.screens.contact.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khriscod.myapplication.presentation.components.DefaultButtom
import com.khriscod.myapplication.presentation.components.DefaultTextField

@Composable
fun ContactContent (viewModel: ContactViewModel) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Formulario para Registro:")
        DefaultTextField(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            value = viewModel.username.value,
            onValueChange = {viewModel.username.value = it},
            label = "Nombre",
            icon = Icons.Default.Person,
            contentDescription = "nombre de usuario",
            errMsg = viewModel.usernameErrMsg.value,
            validateField = {viewModel.validateUsername()}
        )

        DefaultTextField(
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxWidth(),
            value = viewModel.email.value,
            onValueChange = {viewModel.email.value = it},
            label = "Correo",
            icon = Icons.Default.Email,
            contentDescription = "Correo Electronico",
            errMsg = viewModel.emailErrMsg.value,
            validateField = {viewModel.validateEmail()}
        )

        DefaultTextField(
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxWidth(),
            value = viewModel.phone.value,
            onValueChange = {viewModel.phone.value = it},
            label = "Celular",
            icon = Icons.Default.Phone,
            contentDescription = "Numero Telefonico",
            errMsg = viewModel.phoneErrMsg.value,
            validateField = {viewModel.validatePhone()}
        )

        DefaultTextField(
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxWidth(),
            value = viewModel.address.value,
            onValueChange = {viewModel.address.value = it},
            label = "Direccion",
            icon = Icons.Default.Info,
            contentDescription = "Direccion de Habitacion",
            errMsg = viewModel.addressErrMsg.value,
            validateField = {viewModel.validateAddress()}
        )

        DefaultButtom(
            text = "ENVIAR",
            onClick = { /*TODO*/ },
            enabled = viewModel.isEnabledContactButton)
    }
}