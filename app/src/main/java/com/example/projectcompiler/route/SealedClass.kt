package com.example.projectcompiler.route

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object BusinessCard : Screen("businessCard")
    object Birthday : Screen("birthdayCard")
    object DiceWithButtonAndImage : Screen("diceActivity")
    object TipTimeLayout : Screen("tipTimeLayout")
    object Lemonade : Screen("lemonade")
    object Affirmation : Screen("affirmation")
}
