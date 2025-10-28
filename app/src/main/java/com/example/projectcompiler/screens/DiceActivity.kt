package com.example.projectcompiler.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun DiceWithButtonAndImage(navController: NavController,) {
    var result by remember { mutableIntStateOf(1) }
    var lives by remember { mutableIntStateOf(20) }
    var showGameOver by remember { mutableStateOf(false) }

    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
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
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.padding(bottom = 44.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Lives: ",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = lives.toString(),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = result.toString(),
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "Dice showing $result"
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val newResult = (1..6).random()
                    result = newResult

                    if (lives > 0) {
                        lives -= newResult
                        if (lives <= 0) {
                            lives = 0
                            showGameOver = true
                        }
                    }
                }
            ) {
                Text(text = "Roll")
            }
        }
    }

    if (showGameOver) {
        AlertDialog(
            onDismissRequest = { showGameOver = false },
            title = { Text("Game Over!", fontSize = 30.sp, fontWeight = FontWeight.Bold) },
            text = { Text("You’ve run out of lives.") },
            confirmButton = {
                Button(onClick = {
                    showGameOver = false
                    lives = 20
                    result = 1
                }) {
                    Text("Play Again")
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiceWithButtonAndImagePreview() {
    DiceWithButtonAndImage(navController = NavController(LocalContext.current),)
}
