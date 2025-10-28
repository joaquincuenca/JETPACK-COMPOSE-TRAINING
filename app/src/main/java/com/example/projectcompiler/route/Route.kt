package com.example.projectcompiler.route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectcompiler.screens.Affirmation
import com.example.projectcompiler.screens.AffirmationsApp
import com.example.projectcompiler.screens.Birthday
import com.example.projectcompiler.screens.BusinessCard
import com.example.projectcompiler.screens.DiceWithButtonAndImage
import com.example.projectcompiler.screens.Home
import com.example.projectcompiler.screens.Lemonade
import com.example.projectcompiler.screens.TipTimeLayout

@Composable
fun MyApp(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            Home(navController = navController)
        }
        composable(Screen.BusinessCard.route) {
            BusinessCard(
                navController = navController,
                name = "Joaquin Cuenca",
                facebook = "Joaquin Cuenca",
                email = "jcuenca633@gmail.com",
                phone = "+63-965-612-1577"
            )
        }
        composable(Screen.Birthday.route) {
            Birthday(
                navController = navController,
                message = "HAPPY BIRTHDAY SAM!",
                from = "-SuperFam",
            )
        }
        composable(Screen.DiceWithButtonAndImage.route) {
            DiceWithButtonAndImage(
                navController = navController,
            )
        }
        composable(Screen.TipTimeLayout.route) {
            TipTimeLayout(
                navController = navController
            )
        }
        composable(Screen.Lemonade.route) {
            Lemonade(navController = navController)
        }
        composable(Screen.Affirmation.route) {
            AffirmationsApp(navController = navController)
        }
    }
}