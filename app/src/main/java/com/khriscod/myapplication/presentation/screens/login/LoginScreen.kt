package com.khriscod.myapplication.presentation.screens.login


import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.khriscod.myapplication.presentation.screens.login.components.LoginBottomBar
import com.khriscod.myapplication.presentation.screens.login.components.LoginContent


@Composable
fun LoginScreen(navController: NavHostController) {


    Scaffold(
        topBar = {},
        content = {it
            LoginContent() },
        bottomBar = {
           LoginBottomBar(navController)
        }
    )
}


