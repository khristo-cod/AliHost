package com.khriscod.myapplication.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khriscod.myapplication.presentation.ui.theme.green500

@Composable
fun DefaultButtom(
    text: String,
    onClick:()->Unit ={},
    color: Color = green500,
    color1: Color = Color.Red,
    icon: ImageVector = Icons.Default.ArrowForward,
    enabled: Boolean= true
){

    Column {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),

            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = color),
            enabled = enabled
        ) {

            Icon(imageVector = icon, contentDescription = "Iniciar Sesion")
            Spacer(modifier = Modifier.width(10.dp))
            Text ( text)


        }

    }
   

}
