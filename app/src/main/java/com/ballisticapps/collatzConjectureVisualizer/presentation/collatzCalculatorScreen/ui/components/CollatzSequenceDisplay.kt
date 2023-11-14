package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzCalculatorState

@Composable
fun CollatzSequenceDisplay(
    collatzCalculatorState: CollatzCalculatorState
) {
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
            .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)),
    ) {
        itemsIndexed(
            collatzCalculatorState.collatzBigIntegerSequence
        ) { index, number ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 4.dp)
            ) {
                Text(
                    text = "$index:" +
                            " ",
                    color = textColor,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = "$number",
                    color = textColor, fontSize = 16.sp
                )
            }
        }
    }
}