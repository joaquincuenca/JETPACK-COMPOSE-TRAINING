package com.example.projectcompiler

sealed class Screen(val route: String) {
    object FirstScreen : Screen("home")
    object SecondScreen : Screen("second")
}