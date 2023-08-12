package com.khriscod.myapplication.presentation.screens.search

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.khriscod.myapplication.presentation.components.MenuTopBar
import com.khriscod.myapplication.presentation.components.MyDrawer
import com.khriscod.myapplication.presentation.screens.search.components.SearchContent
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavHostController){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        topBar= { MenuTopBar(title = "CONSULTA",
            upAvailable = true,
            navController = navController,
            onClickDrawer = {coroutineScope.launch { scaffoldState.drawerState.open() }})
        },
        content= {
            SearchContent()
        },
        bottomBar = {},
        scaffoldState= scaffoldState,
        drawerContent = { MyDrawer(navController,{coroutineScope.launch { scaffoldState.drawerState.close() }}) },
        drawerGesturesEnabled = false
    )
}