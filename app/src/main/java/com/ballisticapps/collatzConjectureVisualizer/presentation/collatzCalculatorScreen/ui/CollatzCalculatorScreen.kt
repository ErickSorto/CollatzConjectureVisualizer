package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ballisticapps.collatzConjectureVisualizer.naviagation.components.CollatzCalculatorNavGraph
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzCalculatorState
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@CollatzCalculatorNavGraph(start = true)
@Destination
@Composable
fun CollatzCalculatorScreen(
    collatzViewModel: CollatzViewModel
) {
    val collatzViewModelState =
        collatzViewModel.collatzCalculatorState.collectAsStateWithLifecycle().value

    CollatzCalculatorScreenContent(
        collatzCalculatorState = collatzViewModelState,
        onCollatzEvent = collatzViewModel::onEvent
    )
}

@Preview
@Composable
fun CollatzCalculatorScreenPreview(){
    CollatzCalculatorScreenContent(
        collatzCalculatorState = CollatzCalculatorState()
    )
}