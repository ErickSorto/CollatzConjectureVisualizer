package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzInfoScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzCalculatorState

@Composable
fun CollatzInfoScreenContent(
    collatzCalculatorState: CollatzCalculatorState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Collatz Sequence for ${collatzCalculatorState.enteredNumber}",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Divider()

        Spacer(modifier = Modifier.height(16.dp))

        // Displaying additional information
        Text("Total Steps: ${collatzCalculatorState.collatzTotalSteps}")
        Text("Total Even Numbers: ${collatzCalculatorState.collatzTotalEven}")
        Text("Total Odd Numbers: ${collatzCalculatorState.collatzTotalOdd}")
        Text("Even Percentage: ${collatzCalculatorState.collatzEvenPercentage}%")
        Text("Odd Percentage: ${collatzCalculatorState.collatzOddPercentage}%")
        Text("Largest Number: ${collatzCalculatorState.collatzMaximumInt}")
        Text("Step at Largest Number: ${collatzCalculatorState.collatzMaximumIntSteps}")
    }
}
