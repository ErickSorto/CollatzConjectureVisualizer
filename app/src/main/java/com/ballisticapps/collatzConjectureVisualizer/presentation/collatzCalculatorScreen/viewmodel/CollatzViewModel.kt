package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ballisticapps.collatzConjectureVisualizer.data.CollatzCalculator
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.CollatzCalculatorEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.math.BigInteger
import javax.inject.Inject

@HiltViewModel
class CollatzViewModel @Inject constructor(
    private val collatzCalculator: CollatzCalculator
) : ViewModel() {

    private val _collatzViewModelState = MutableStateFlow(CollatzViewModelState())
    val collatzViewModelState: StateFlow<CollatzViewModelState> = _collatzViewModelState.asStateFlow()

    fun onEvent(event: CollatzCalculatorEvent) = viewModelScope.launch {
        when(event){
            is CollatzCalculatorEvent.CalculateCollatzNumber -> {
                computeCollatzSequence(_collatzViewModelState.value.enteredNumber.toBigInteger())
            }
            is CollatzCalculatorEvent.EnteredNumber -> {
                _collatzViewModelState.update { it.copy(enteredNumber = event.value) }
            }
        }
    }
    private fun computeCollatzSequence(numEntered: BigInteger) {
        viewModelScope.launch {
            collatzCalculator.createCollatzList(numEntered).collect { number ->
                _collatzViewModelState.update {
                    it.copy(collatzSequenceList = it.collatzSequenceList + number)
                }
            }
        }
    }
}

data class CollatzViewModelState(
    val collatzSequenceList: List<BigInteger> = mutableListOf(),
    val enteredNumber: String = ""
)
