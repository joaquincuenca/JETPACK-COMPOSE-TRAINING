package com.example.projectcompiler.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projectcompiler.R
import com.example.projectcompiler.route.Screen
import kotlin.random.Random

@Composable
fun Lemonade(navController: NavController) {
    var stage by remember { mutableStateOf(1) }
    var squeezes by remember { mutableStateOf(0) }
    var goal by remember { mutableStateOf(0) }

    val (img, msg) = when (stage) {
        1 -> R.drawable.lemon_tree to "Tap to pick a lemon!"
        2 -> R.drawable.lemon_squeeze to "Keep tapping to squeeze!"
        3 -> R.drawable.lemon_drink to "Tap to drink your lemonade!"
        else -> R.drawable.lemon_restart to "All done! Tap to start again."
    }

    Box(
        Modifier.fillMaxSize().background(Color(0xFF1A1A1A)).padding(24.dp)
    ) {
        Button(
            onClick = { navController.navigate(Screen.Home.route) },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF55ADF8)),
            modifier = Modifier.align(Alignment.TopStart)
        ) { Text("Back", color = Color.White) }

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(img),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clickable {
                        when (stage) {
                            1 -> { stage = 2; goal = Random.nextInt(2, 10); squeezes = 0 }
                            2 -> if (++squeezes >= goal) stage = 3
                            3 -> stage = 4
                            else -> stage = 1
                        }
                    }
            )
            Spacer(Modifier.height(16.dp))
            Text(msg, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White, textAlign = TextAlign.Center)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LemonadePreview() {
    Lemonade(navController = NavController(LocalContext.current))
}
