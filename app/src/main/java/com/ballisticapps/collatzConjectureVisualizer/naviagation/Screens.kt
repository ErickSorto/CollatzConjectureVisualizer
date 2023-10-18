package com.ballisticapps.collatzConjectureVisualizer.naviagation

import com.ballisticapps.CollatzConjectureVisualizer.R

sealed class CollatzScreens(
    val route: String,
    val title: String? = null,
    val icon: Int? = null
) {
    object CalculatorScreen : CollatzScreens(
        route = "calculator_screen",
        title = "Calculator",
        icon = R.drawable.round_home_24
    )

    object UnityVisualizerScreen : CollatzScreens(
        route = "unity_visualizer_screen",
        title = "Visualizer",
        icon = R.drawable.round_visibility_24
    )

    object HistoryScreen : CollatzScreens(
        route = "history_screen",
        title = "History",
        icon = R.drawable.round_history_24
    )

    object InfoScreen : CollatzScreens(
        route = "chart_screen",
        title = "Info",
        icon = R.drawable.round_bar_chart_24
    )
}
