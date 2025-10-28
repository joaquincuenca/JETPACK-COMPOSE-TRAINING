package com.example.projectcompiler.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projectcompiler.route.Screen

@Composable
fun Birthday(
    navController: NavController,
    message: String,
    from: String,
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
            Text(
                text = message,
                fontSize = 40.sp,
                lineHeight = 1.2.em,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            )
            Text(
                text = from,
                fontSize = 22.sp,
                textAlign = TextAlign.End,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, end = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun BirthdayPreview() {
    Birthday(
        navController = NavController(LocalContext.current),
        message = "HAPPY BIRTHDAY SAM!",
        from = "-SuperFam",
    )
}
