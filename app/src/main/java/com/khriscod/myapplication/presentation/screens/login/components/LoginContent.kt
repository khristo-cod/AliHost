package com.khriscod.myapplication.presentation.screens.login.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.khriscod.myapplication.R
import com.khriscod.myapplication.domain.model.Response
import com.khriscod.myapplication.presentation.components.DefaultButtom
import com.khriscod.myapplication.presentation.components.DefaultTextField

@Composable
fun LoginContent() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

    ) {
        BodyLogin()
    }
}

@Composable
fun BodyLogin(viewModel: LoginViewModel = hiltViewModel()) {

    val loginFlow = viewModel.loginFlow.collectAsState()

    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .height(170.dp)
                .padding(top = 70.dp),

            painter = painterResource(id = R.drawable.safe_house),
            contentDescription = "Casa Segura"
        )
        Text(
            text = "ALIADOS"
        )

        DefaultTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 0.dp),
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = "Correo Electronico",
            icon = Icons.Default.Email,
            contentDescription = "correo electronico",
            errMsg = viewModel.emailErrMsg.value,
            validateField = { viewModel.validateEmail()}
        )

        Spacer(modifier = Modifier.height(5.dp))

        DefaultTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 0.dp),
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            label = "Contraseña",
            icon = Icons.Default.Lock,
            contentDescription = "Contraseña",
            hideText = true,
            errMsg = viewModel.passwordErrMsg.value,
            validateField = { viewModel.validatePassword()}
        )

        DefaultButtom(
            text = "INICIAR SESION",
            onClick = {
                viewModel.login()
            },
            enabled = viewModel.isEnabledLoginButton
            )
    }

    loginFlow.value.let {
        when(it){
            // mostrar que esta realizando la peticion y todavia esta en proceso
            Response.Loading ->{
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    CircularProgressIndicator()
                }
            }
            is Response.Success -> {
                Toast.makeText(LocalContext.current, "USUARIO LOGEADO", Toast.LENGTH_LONG).show()
            }
            is Response.Failure -> {

                Toast.makeText(LocalContext.current, it.exception?.message?: "Error Desconocido" , Toast.LENGTH_LONG).show()
            }
            else -> {}
        }

    }
}
