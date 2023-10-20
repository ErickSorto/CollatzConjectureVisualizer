package com.ballisticapps.collatzConjectureVisualizer.naviagation

import com.ballisticapps.CollatzConjectureVisualizer.R
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzCalculatorScreenDestination
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzHistoryScreenDestination
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzInfoScreenDestination
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzUnityScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

sealed class Screens(
    val direction: DirectionDestinationSpec,
    val title: String? = null,
    val icon: Int? = null
) {
    data object CalculatorScreen : Screens(
        direction = CollatzCalculatorScreenDestination,
        title = "Calculator",
        icon = R.drawable.round_home_24
    )

    data object UnityVisualizerScreen : Screens(
        direction = CollatzUnityScreenDestination,
        title = "Visualizer",
        icon = R.drawable.round_visibility_24
    )

    data object HistoryScreen : Screens(
        direction = CollatzHistoryScreenDestination,
        title = "History",
        icon = R.drawable.round_history_24
    )

    data object InfoScreen : Screens(
        direction = CollatzInfoScreenDestination,
        title = "Info",
        icon = R.drawable.round_bar_chart_24
    )
}
