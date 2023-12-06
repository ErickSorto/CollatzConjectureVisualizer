package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzHistoryScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ballisticapps.collatzConjectureVisualizer.naviagation.components.CollatzCalculatorNavGraph
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ramcosta.composedestinations.annotation.Destination

@CollatzCalculatorNavGraph
@Destination
@Composable
fun CollatzHistoryScreen(
    collatzHistoryViewModel: CollatzViewModel
){
    Text(text = "CollatzHistoryScreen")
}
