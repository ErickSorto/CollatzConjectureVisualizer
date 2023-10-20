package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen

sealed class CollatzCalculatorEvent {
    data class EnteredNumber(val value: String) : CollatzCalculatorEvent()
    data object CalculateCollatzNumber: CollatzCalculatorEvent()
}