package com.ballisticapps.collatzConjectureVisualizer.naviagation

import androidx.annotation.DrawableRes
import com.ballisticapps.CollatzConjectureVisualizer.R
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzCalculatorScreenDestination
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzHistoryScreenDestination
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzInfoScreenDestination
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzUnityScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class Screens(val direction: DirectionDestinationSpec, val title: String, @DrawableRes val icon: Int) {
    CALCULATOR(CollatzCalculatorScreenDestination, "Calculator", R.drawable.round_home_24),
    VISUALIZER(CollatzUnityScreenDestination, "Visualizer", R.drawable.round_visibility_24),
    HISTORY(CollatzHistoryScreenDestination, "History", R.drawable.round_history_24),
    INFO(CollatzInfoScreenDestination, "Info", R.drawable.round_bar_chart_24);
}
