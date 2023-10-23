package com.ballisticapps.collatzConjectureVisualizer.presentation.mainScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.ballisticapps.collatzConjectureVisualizer.presentation.NavGraphs
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.CollatzCalculatorScreen
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzCalculatorScreenDestination
import com.ballisticapps.collatzConjectureVisualizer.presentation.mainScreen.components.BottomNavigation
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.root,
            modifier = Modifier.padding(it),
            dependenciesContainerBuilder = {
                dependency(CollatzCalculatorScreenDestination) {
                    hiltViewModel<CollatzViewModel>()
                }
            }
        )
    }
}