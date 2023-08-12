package com.khriscod.myapplication.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DefaultTopBar (
    title:String,
    upAvailable:Boolean=false,
    navController: NavHostController? = null
){

    TopAppBar(title = {
        Text(
            text = title,
            fontSize = 16.sp,
        )
    },
    navigationIcon = {
        if (upAvailable) {
            IconButton(onClick = { navController?.popBackStack()}) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver Atras")
            }
        }
    }
        )
}