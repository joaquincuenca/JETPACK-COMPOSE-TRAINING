package com.example.projectcompiler.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun Birthday(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Button(onClick = {

        }) {
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

@Preview(showBackground = true)
@Composable
fun BirthdayPreview() {
    Birthday(
        message = "INOM TAYO SA FRIDAY",
        from = "-SuperFam",
    )
}
