package com.khriscod.myapplication.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.khriscod.myapplication.presentation.navigation.AppScreen

@Composable
fun MenuTopBar (onClickDrawer: ()->Unit,
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
            IconButton(onClick = {onClickDrawer()}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menú")
            }
        }
    })


}

@Composable
fun MyDrawer(navController: NavHostController,  onClosedDrawer:()->Unit){
    Column(Modifier.padding(8.dp)) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp)){
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                ) {
                IconButton(onClick = { onClosedDrawer()}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver Atras")
                }
                Text(text = "MENU")
            }

        }

        Text(text = "Home", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(route = AppScreen.Home.route) })
        Text(text = "Consultar", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(route = AppScreen.Search.route) })
        Text(text = "Tienda", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(route = AppScreen.Store.route) })
        Text(text = "Perfil", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(route = AppScreen.Profile.route) })
        Text(text = "Cerrar Sesion", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController?.popBackStack() })


        //IconButton(onClick = { navController?.popBackStack()}) {
    }
}