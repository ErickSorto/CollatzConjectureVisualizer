package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzRecentScreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ballisticapps.collatzConjectureVisualizer.naviagation.components.CollatzCalculatorNavGraph
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@CollatzCalculatorNavGraph
@Destination
@Composable
fun CollatzRecentScreen(
    collatzViewModel: CollatzViewModel,
    navigator: DestinationsNavigator,
){
    val collatzViewModelState =
        collatzViewModel.collatzCalculatorState.collectAsStateWithLifecycle().value
    CollatzRecentNumbersContent(
        collatzCalculatorState = collatzViewModelState,
        onEvent = collatzViewModel::onEvent,
        navigator = navigator
    )
}
