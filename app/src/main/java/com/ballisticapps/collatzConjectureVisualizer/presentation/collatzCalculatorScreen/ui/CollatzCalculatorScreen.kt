package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
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