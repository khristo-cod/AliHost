package com.khriscod.myapplication.presentation.screens.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.khriscod.myapplication.presentation.navigation.AppScreen

@Composable
fun LoginBottomBar(navController: NavHostController) {
   Column(){
       Divider(
           Modifier
               .background(Color(0xFFF9F9F9))
               .height(1.dp)
               .fillMaxWidth()

       )
       Row(
           Modifier
               .fillMaxWidth()
               .padding(top = 10.dp),
           horizontalArrangement = Arrangement.Center
       ) {

           Text(
               text = "¿Aun no estas Registrado?",
               fontSize = 14.sp
           )
           Spacer(modifier = Modifier.width(5.dp))
           Text(
               modifier = Modifier.clickable { navController.navigate(route=AppScreen.Contac.route)},
               text = "¡CONTACTANOS!",
               fontSize = 14.sp,
               color = Color.Blue,
               fontWeight = FontWeight.Bold
           )
       }
       Column(
           Modifier.fillMaxWidth().padding(bottom = 10.dp),
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Text(

               text = "Al usar esta APP, aceptas nuestras:",
               fontSize = 14.sp
           )
           Text(
               modifier = Modifier.clickable { navController.navigate(route=AppScreen.Home.route)},
               text = "POLITICAS DE PRIVACIDAD, TERMINOS Y CONDICIONES",
               fontSize = 14.sp,
               color = Color.Blue,
               fontWeight = FontWeight.Bold
           )
       }

   }



}