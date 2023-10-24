package com.ballisticapps.collatzConjectureVisualizer.presentation.mainScreen.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults.colors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ballisticapps.CollatzConjectureVisualizer.R
import com.ballisticapps.collatzConjectureVisualizer.naviagation.Screens
import com.ballisticapps.collatzConjectureVisualizer.presentation.NavGraphs
import com.ballisticapps.collatzConjectureVisualizer.presentation.appCurrentDestinationAsState
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.Destination
import com.ballisticapps.collatzConjectureVisualizer.presentation.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.isRouteOnBackStack


@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        Screens.CalculatorScreen,
        Screens.InfoScreen,
        Screens.UnityVisualizerScreen,
        Screens.HistoryScreen
    )

    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    val colorBottomBar = if (isSystemInDarkTheme()) colorResource(id = R.color.black)
    else Color.White

    val colorBottomBarText = if (isSystemInDarkTheme()) colorResource(id = R.color.white)
    else Color.Black
    NavigationBar(
        containerColor = colorBottomBar,
    ) {
        items.forEach { item ->
            val isCurrentDestOnBackStack = navController.isRouteOnBackStack(item.direction)
            NavigationBarItem(
                icon = {
                    item.icon?.let {
                        Icon(
                            painter = painterResource(id = it),
                            "${item.title}"
                        )
                    }
                },
                label = {
                    item.title?.let {
                        Text(
                            text = it,
                            fontSize = 9.sp
                        )
                    }
                },
                alwaysShowLabel = true,
                selected = currentDestination == item.direction,
                onClick = {
                    if (isCurrentDestOnBackStack) {
                        // When we click again on a bottom bar item and it was already selected
                        // we want to pop the back stack until the initial destination of this bottom bar item
                        navController.popBackStack(item.direction, false)
                        return@NavigationBarItem
                    }
                    navController.navigate(item.direction) {
                        popUpTo(NavGraphs.root) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = colors(
                    selectedIconColor = colorBottomBar,
                    selectedTextColor = colorBottomBarText,
                    indicatorColor = colorBottomBarText,
                    disabledIconColor = colorBottomBar,
                    disabledTextColor = colorBottomBarText,
                )
            )
        }
    }
}
