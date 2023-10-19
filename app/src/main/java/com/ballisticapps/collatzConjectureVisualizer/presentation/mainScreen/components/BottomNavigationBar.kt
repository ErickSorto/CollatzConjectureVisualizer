package com.ballisticapps.collatzConjectureVisualizer.presentation.mainScreen.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.ballisticapps.collatzConjectureVisualizer.naviagation.Screens
import com.ramcosta.composedestinations.navigation.navigate

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        Screens.CalculatorScreen,
        Screens.InfoScreen,
        Screens.UnityVisualizerScreen,
        Screens.HistoryScreen
    )

    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.Black,
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { item.icon?.let { painterResource(id = it) } },
                label = {
                    item.title?.let {
                        Text(
                            text = it,
                            fontSize = 9.sp
                        )
                    }
                },
                alwaysShowLabel = true,
                selected = navController.currentDestination == item.direction,
                onClick = {
                    navController.navigate(item.direction, fun NavOptionsBuilder.() {
                        launchSingleTop = true
                    })
                }
            )
        }
    }
}
