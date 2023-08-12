package com.khriscod.myapplication.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.khriscod.myapplication.presentation.components.MenuTopBar
import com.khriscod.myapplication.presentation.components.MyDrawer
import com.khriscod.myapplication.presentation.screens.home.components.HomeContent
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        topBar= {
            MenuTopBar(title = "HOME",
                upAvailable = true,
                navController = navController,

                onClickDrawer = {coroutineScope.launch { scaffoldState.drawerState.open() }})},
        content= { HomeContent()},
        scaffoldState= scaffoldState,
        bottomBar = {},
        drawerContent = { MyDrawer(navController,{coroutineScope.launch { scaffoldState.drawerState.close() }})},
        drawerGesturesEnabled = false
    )
}