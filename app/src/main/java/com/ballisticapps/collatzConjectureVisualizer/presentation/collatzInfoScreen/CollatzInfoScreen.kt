package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzInfoScreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ballisticapps.collatzConjectureVisualizer.naviagation.components.CollatzCalculatorNavGraph
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ramcosta.composedestinations.annotation.Destination

@CollatzCalculatorNavGraph
@Destination
@Composable
fun CollatzInfoScreen(
    collatzViewModel: CollatzViewModel
) {
    val collatzCalculatorState =
        collatzViewModel.collatzCalculatorState.collectAsStateWithLifecycle().value

    CollatzInfoScreenContent(
        collatzCalculatorState = collatzCalculatorState
    )
}