package com.example.projectcompiler.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projectcompiler.R
import com.example.projectcompiler.route.Screen

data class Projects(
    @DrawableRes val backgroundResId: Int,
    val title: String,
    val language: String,
    val onClick: () -> Unit = {}
)
@Composable
fun Home(navController: NavController) {
    val projects = listOf(
        Projects(R.drawable.bg1, "Business Card", "Tap to view details", onClick = {navController.navigate(Screen.BusinessCard.route)}),
        Projects(R.drawable.bg2, "Birthday Card", "Tap to view details", onClick = {navController.navigate(Screen.Birthday.route)}),
        Projects(R.drawable.bg3, "Dice Activity", "Tap to view details", onClick = {navController.navigate(Screen.DiceWithButtonAndImage.route)}),
        Projects(R.drawable.bg4, "Tip Calculator", "Tap to view details", onClick = {navController.navigate(Screen.TipTimeLayout.route)}),
        Projects(R.drawable.bg5, "Lemonade", "Tap to view details", onClick = {navController.navigate(Screen.Lemonade.route)}),
        Projects(R.drawable.bg1, "Affirmation", "Tap to view details", onClick = {navController.navigate(Screen.Affirmation.route)}),
    )
    Box(modifier = Modifier.background(Color(0xFF121212))) {
        LazyColumn(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(projects) { project ->
                ProjectCard(project)
            }
        }
    }
}
@Composable
fun ProjectCard(project: Projects) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.DarkGray)
            .clickable { project.onClick() }
    ) {

        Image(
            painter = painterResource(id = project.backgroundResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp)
                .background(Color(0xFF121212)),
        ) {
            Text(
                text = project.title,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = project.language,
                color = Color.LightGray,
                fontSize = 14.sp,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    Home(navController = NavController(LocalContext.current) )
}
