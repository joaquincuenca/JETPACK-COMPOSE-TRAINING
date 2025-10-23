package com.example.projectcompiler

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectcompiler.screens.Birthday
import com.example.projectcompiler.screens.BusinessCard

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.FirstScreen.route) {
        composable(Screen.FirstScreen.route) {
            Birthday(
                message = "INOM TAYO SA FRIDAY",
                from = "-SuperFam",
                onBackClick = {})
        }
        composable(Screen.SecondScreen.route) {
            BusinessCard(
                name = "Joaquin Cuenca",
                facebook = "Joaquin Cuenca",
                email = "joaquincuenca@gmail.com",
                phone = 1234567890,
                onBackClick = {})
        }
    }
}
