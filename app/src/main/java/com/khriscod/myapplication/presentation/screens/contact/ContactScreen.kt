package com.khriscod.myapplication.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.khriscod.myapplication.presentation.components.DefaultTopBar
import com.khriscod.myapplication.presentation.screens.contact.components.ContactContent
import com.khriscod.myapplication.presentation.screens.contact.components.ContactViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Contact(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "CONTACTO",
                upAvailable = true,
                navController = navController,
            ) },
        content = {
           ContactContent(viewModel = ContactViewModel())
        },
        bottomBar = {

        }
    )
}