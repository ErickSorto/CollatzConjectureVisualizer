package com.ballisticapps.collatzConjectureVisualizer.presentation.mainScreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.ballisticapps.collatzConjectureVisualizer.presentation.mainScreen.components.BottomNavigation

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
           BottomNavigation(navController = navController)
        }
    ) {
        it

    }
}