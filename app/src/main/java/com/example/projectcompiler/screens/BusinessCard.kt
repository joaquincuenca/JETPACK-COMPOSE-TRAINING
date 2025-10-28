package com.example.projectcompiler.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projectcompiler.R
import com.example.projectcompiler.route.Screen

@Composable
fun BusinessCard(
    navController: NavController,
    name: String,
    facebook: String,
    email: String,
    phone: String,
    modifier: Modifier = Modifier
) {
    val brush = Brush.verticalGradient(listOf(Color.DarkGray, Color.White))

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush)
            .padding(16.dp)
    ) {
        Button(
            onClick = { navController.navigate(Screen.Home.route) },
            modifier = Modifier.align(Alignment.TopStart),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF55ADF8),
                contentColor = Color.White
            ),

            ) {
            Text(text = "Back")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.mecopy),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(220.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )
                Text(
                    text = name,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "Android Developer",
                    fontSize = 18.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ContactRow(
                    iconRes = R.drawable.phone,
                    text = phone
                )
                ContactRow(
                    iconRes = R.drawable.facebook,
                    text = facebook
                )
                ContactRow(
                    iconRes = R.drawable.email,
                    text = email
                )
            }
        }
    }
}

@Composable
fun ContactRow(iconRes: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
                .padding(end = 5.dp)
        )
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = text,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Composable
@Preview
fun BusinessCardPreview() {
    BusinessCard(
        navController = NavController(LocalContext.current),
        name = "Joaquin Cuenca",
        facebook = "Joaquin Cuenca",
        email = "joaquincuenca@gmail.com",
        phone = "1234567890",
    )

}