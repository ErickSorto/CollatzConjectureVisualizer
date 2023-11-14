package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzCalculatorState

@Composable
fun CollatzIterationTitle(
    collatzCalculatorState: CollatzCalculatorState
) {
    val titleOff = remember { mutableStateOf(false) }
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    if (collatzCalculatorState.collatzBigIntegerSequence.isEmpty() && !titleOff.value) {
        Text(
            text = "Collatz Conjecture",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ),
            color = textColor,
            textAlign = TextAlign.Center
        )
    } else {
        titleOff.value = true
        Text(
            text = "Total Iteration",
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(
                fontSize = 16.sp,
            ),
            color = textColor,
            textAlign = TextAlign.Center
        )
        Text(
            text = (
                    if (collatzCalculatorState.collatzBigIntegerSequence.isEmpty()) "0"
                    else (collatzCalculatorState.collatzBigIntegerSequence.size - 1).toString()),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ),
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}