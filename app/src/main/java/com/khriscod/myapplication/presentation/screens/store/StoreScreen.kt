package com.khriscod.myapplication.presentation.screens.store

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.khriscod.myapplication.presentation.components.MenuTopBar
import com.khriscod.myapplication.presentation.components.MyDrawer
import com.khriscod.myapplication.presentation.screens.store.components.StoreContent
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StoreScreen(navController: NavHostController){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        topBar= { MenuTopBar(title = "TIENDA",
            upAvailable = true,
            navController = navController,
            onClickDrawer = {coroutineScope.launch { scaffoldState.drawerState.open() }})
        },
        content= { StoreContent()},
        bottomBar = {},
        scaffoldState= scaffoldState,
        drawerContent = { MyDrawer(navController,{coroutineScope.launch { scaffoldState.drawerState.close() }}) },
        drawerGesturesEnabled = false
    )
}