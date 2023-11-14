package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components

sealed class CollatzCalculatorEvent {
    data class EnteredNumber(val value: String) : CollatzCalculatorEvent()
    data object CalculateCollatzNumber: CollatzCalculatorEvent()
}