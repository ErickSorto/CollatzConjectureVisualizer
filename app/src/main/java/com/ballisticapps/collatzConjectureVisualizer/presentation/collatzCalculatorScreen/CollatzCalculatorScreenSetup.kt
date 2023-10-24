package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.components.CollatzInputLayout
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun CollatzCalculatorScreenSetup(
    collatzViewModel: CollatzViewModel
) {
    val collatzBigIntegerSequenceList by
        collatzViewModel.collatzBigIntegerSequence.collectAsStateWithLifecycle()

    val enteredNumber =
        collatzViewModel.collatzViewState.collectAsStateWithLifecycle().value

    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val titleOff = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        if (collatzBigIntegerSequenceList.isEmpty() && !titleOff.value) {
            Text(
                text = "Collatz Conjecture",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                style = androidx.compose.ui.text.TextStyle(
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
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                ),
                color = textColor,
                textAlign = TextAlign.Center
            )
            Text(
                text = (
                        if (collatzBigIntegerSequenceList.isEmpty()) "0"
                        else (collatzBigIntegerSequenceList.size - 1).toString()
                        ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = textColor,
                textAlign = TextAlign.Center
            )
        }
        CollatzInputLayout(
            collatzCalculatorEvent = {
                collatzViewModel.onEvent(it)
            },
            enteredNumber = enteredNumber.enteredNumber,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)),
        ) {
            itemsIndexed(collatzBigIntegerSequenceList) { index, number ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp, horizontal = 4.dp)
                ) {
                    Text(
                        text = "$index: ",
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
}
