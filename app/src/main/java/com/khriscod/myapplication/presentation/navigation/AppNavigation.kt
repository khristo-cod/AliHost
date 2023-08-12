package com.khriscod.myapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.khriscod.myapplication.presentation.screens.home.HomeScreen
import com.khriscod.myapplication.presentation.screens.login.Contact
import com.khriscod.myapplication.presentation.screens.login.LoginScreen
import com.khriscod.myapplication.presentation.screens.profile.ProfileScreen
import com.khriscod.myapplication.presentation.screens.search.SearchScreen
import com.khriscod.myapplication.presentation.screens.store.StoreScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ){
        composable(route = AppScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AppScreen.Contac.route){
            Contact(navController)
        }
        composable(route = AppScreen.Home.route){
            HomeScreen(navController)
        }
        composable(route = AppScreen.Store.route){
            StoreScreen(navController)
        }
        composable(route = AppScreen.Search.route){
            SearchScreen(navController)
        }
        composable(route = AppScreen.Profile.route){
            ProfileScreen(navController)
        }
    }
}