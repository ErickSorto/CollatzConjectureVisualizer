package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components.CollatzCalculatorEvent
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components.CollatzInputLayout
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components.CollatzIterationTitle
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components.CollatzSequenceDisplay
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzCalculatorState

@Composable
fun CollatzCalculatorScreenContent(
    collatzCalculatorState: CollatzCalculatorState,
    onCollatzEvent: (CollatzCalculatorEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        CollatzIterationTitle(collatzCalculatorState = collatzCalculatorState)
        CollatzInputLayout(
            collatzCalculatorEvent = {
                onCollatzEvent(it)
            },
            enteredNumber = collatzCalculatorState.enteredNumber,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
        CollatzSequenceDisplay(collatzCalculatorState = collatzCalculatorState)
    }
}
