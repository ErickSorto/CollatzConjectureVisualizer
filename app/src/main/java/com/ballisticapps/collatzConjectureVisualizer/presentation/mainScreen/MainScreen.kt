package com.ballisticapps.collatzConjectureVisualizer.presentation.mainScreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.CollatzCalculatorScreen
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ballisticapps.collatzConjectureVisualizer.presentation.mainScreen.components.BottomNavigation
import com.ballisticapps.collatzConjectureVisualizer.ui.theme.CollatzConjectureVisualizerTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
           BottomNavigation(navController = navController)
        }
    ) {
        it
        CollatzConjectureVisualizerTheme {
            val collatzCalculatorViewModel: CollatzViewModel = hiltViewModel()
            CollatzCalculatorScreen(collatzViewModel = collatzCalculatorViewModel)
        }
    }
}