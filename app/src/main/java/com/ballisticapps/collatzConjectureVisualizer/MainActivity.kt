package com.ballisticapps.collatzConjectureVisualizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.CollatzCalculatorScreen
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel.CollatzViewModel
import com.ballisticapps.collatzConjectureVisualizer.ui.theme.CollatzConjectureVisualizerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CollatzConjectureVisualizerTheme {
                val collatzCalculatorViewModel: CollatzViewModel = hiltViewModel()
                val collatzViewModelState =
                    collatzCalculatorViewModel.collatzViewModelState.collectAsStateWithLifecycle().value
                CollatzCalculatorScreen(
                    collatzCalculatorEvent = collatzCalculatorViewModel::onEvent,
                    collatzViewModelState = collatzViewModelState)
            }
        }
    }
}
