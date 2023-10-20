package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.CollatzCalculatorEvent
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModelState

@Composable
fun CollatzInputLayout(
    collatzCalculatorEvent: (CollatzCalculatorEvent) -> Unit,
    collatzViewModelState: CollatzViewModelState,
    modifier: Modifier
) {
    Row(
        modifier = modifier
    ){
        TextField(
            value = collatzViewModelState.enteredNumber,
            onValueChange = {collatzCalculatorEvent(CollatzCalculatorEvent.EnteredNumber(it))},
            label = { Text("Enter Number") },
            singleLine = true,
            modifier = Modifier.weight(2f)
        )
        Button(
            onClick = { collatzCalculatorEvent(CollatzCalculatorEvent.CalculateCollatzNumber) },
            ) {
            Text("Calculate")
        }
    }
}
