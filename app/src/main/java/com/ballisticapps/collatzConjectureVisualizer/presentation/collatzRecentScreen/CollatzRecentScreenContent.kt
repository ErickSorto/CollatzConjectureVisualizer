package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzRecentScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components.CollatzCalculatorEvent
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzCalculatorState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ballisticapps.collatzConjectureVisualizer.presentation.destinations.CollatzCalculatorScreenDestination
@Composable
fun CollatzRecentNumbersContent(
    collatzCalculatorState: CollatzCalculatorState,
    onEvent: (CollatzCalculatorEvent) -> Unit = {},
    navigator: DestinationsNavigator
) {
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Recent Numbers",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ),
            color = textColor,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Display each recent number in a card, most recent first
        collatzCalculatorState.recentBigInteger.asReversed().forEach { number ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onEvent(CollatzCalculatorEvent.EnteredNumber(number.toString()))
                        onEvent(CollatzCalculatorEvent.CalculateCollatzNumber)
                        navigator.navigate(
                            CollatzCalculatorScreenDestination()
                        )
                    },
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = number.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}
