package com.example.projectcompiler.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectcompiler.R

@Composable
fun BusinessCard(
    name: String,
    facebook: String,
    email: String,
    phone: Int,
    onBackClick: () -> Unit,
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
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            Text(text = "Back")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp), // adds spacing below the back button
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
                    text = "$phone"
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
        name = "Joaquin Cuenca",
        facebook = "Joaquin Cuenca",
        email = "joaquincuenca@gmail.com",
        phone = 1234567890,
        onBackClick = {}
    )

}