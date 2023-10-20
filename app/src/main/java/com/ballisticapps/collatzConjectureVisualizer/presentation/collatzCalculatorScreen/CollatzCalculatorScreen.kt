package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.components.CollatzInputLayout
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModelState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun CollatzCalculatorScreen(
    collatzCalculatorEvent: (CollatzCalculatorEvent) -> Unit,
    collatzViewModelState: CollatzViewModelState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CollatzInputLayout(
            collatzCalculatorEvent = collatzCalculatorEvent,
            collatzViewModelState = collatzViewModelState,
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            items(collatzViewModelState.collatzSequenceList) { number ->
                Text(text = number.toString())
            }
        }
    }
}
