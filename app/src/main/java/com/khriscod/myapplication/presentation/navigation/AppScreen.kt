package com.khriscod.myapplication.presentation.navigation

sealed class AppScreen(val route:String){
    object Login: AppScreen("Login")
    object Contac: AppScreen("Contact")
    object Home: AppScreen("Home")
    object Search: AppScreen("Search")
    object Store: AppScreen("Store")
    object Profile: AppScreen("profile")
}
