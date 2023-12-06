package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzInfoScreen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzCalculatorState

@Composable
fun CollatzInfoScreenContent(
    collatzCalculatorState: CollatzCalculatorState
) {
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sequence Info",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ),
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        val infoList = listOf(
            "Total Steps" to collatzCalculatorState.collatzTotalSteps.toString(),
            "Total Even Numbers" to collatzCalculatorState.collatzTotalEven.toString(),
            "Total Odd Numbers" to collatzCalculatorState.collatzTotalOdd.toString(),
            "Even Percentage" to "${collatzCalculatorState.collatzEvenPercentage}%",
            "Odd Percentage" to "${collatzCalculatorState.collatzOddPercentage}%",
            "Step at Largest Number" to collatzCalculatorState.collatzMaximumIntSteps.toString(),
            "Largest Number" to collatzCalculatorState.collatzMaximumInt.toString(),
        )

        for (info in infoList) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Text("${info.first}: ",
                            style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(info.second, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
