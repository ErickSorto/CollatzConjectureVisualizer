package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.math.BigInteger

@HiltViewModel
class CollatzViewModel() : ViewModel() {

    private val _collatzViewModelState = MutableStateFlow(CollatzViewModelState())
    val collatzViewModelState: StateFlow<CollatzViewModelState> = _collatzViewModelState.asStateFlow()
}

data class CollatzViewModelState(
    val collatzSequenceList: MutableList<BigInteger> = mutableListOf(),
)
