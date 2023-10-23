package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.CollatzCalculatorEvent

@Composable
fun CollatzInputLayout(
    collatzCalculatorEvent: (CollatzCalculatorEvent) -> Unit,
    enteredNumber: String,
    modifier: Modifier
) {

    TextField(
        value = enteredNumber,
        onValueChange = { collatzCalculatorEvent(CollatzCalculatorEvent.EnteredNumber(it)) },
        label = { Text("Enter Number") },
        maxLines = Int.MAX_VALUE,
        trailingIcon = {
            Button(
                onClick = { collatzCalculatorEvent(CollatzCalculatorEvent.CalculateCollatzNumber) },
                colors = buttonColors(
                    containerColor = Color.Transparent,
                )
            ) {
                Text(
                    "Calculate",
                    color = isSystemInDarkTheme().let { if (it) Color.White else Color.Black },
                    )
            }
        },

        modifier = modifier.height(56.dp),
    )
}
