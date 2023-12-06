package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzHistoryScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun CollatzHistoryScreen(
    collatzHistoryViewModel: CollatzViewModel
){
    Text(text = "CollatzHistoryScreen")
}
