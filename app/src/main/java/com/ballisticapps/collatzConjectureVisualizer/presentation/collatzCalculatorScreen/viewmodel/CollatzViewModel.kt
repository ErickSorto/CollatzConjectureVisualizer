package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ballisticapps.collatzConjectureVisualizer.data.CollatzCalculator
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.CollatzCalculatorEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.math.BigInteger
import javax.inject.Inject

@HiltViewModel
class CollatzViewModel @Inject constructor(
    private val collatzCalculator: CollatzCalculator
) : ViewModel() {

    // StateFlow for enteredNumber and other state
    private val _collatzViewState = MutableStateFlow(CollatzViewState())
    val collatzViewState: StateFlow<CollatzViewState> = _collatzViewState.asStateFlow()

    private val _collatzBigIntegerSequence = MutableStateFlow<List<BigInteger>>(emptyList())
    val collatzBigIntegerSequence: StateFlow<List<BigInteger>> = _collatzBigIntegerSequence.asStateFlow()

    fun onEvent(event: CollatzCalculatorEvent) = viewModelScope.launch {
        when(event){
            is CollatzCalculatorEvent.CalculateCollatzNumber -> {
                _collatzBigIntegerSequence.value = emptyList()
                computeCollatzSequence(collatzViewState.value.enteredNumber.toBigIntegerOrNull() ?: BigInteger.ZERO)
            }
            is CollatzCalculatorEvent.EnteredNumber -> {
                _collatzViewState.value = collatzViewState.value.copy(enteredNumber = event.value)
            }
        }
    }

    private fun computeCollatzSequence(numEntered: BigInteger) {
        viewModelScope.launch {
            val tempList = ArrayList<BigInteger>()
            collatzCalculator.createCollatzList(numEntered).collect { number ->
                tempList.add(number)
            }
            _collatzBigIntegerSequence.value = tempList
        }
    }

}

data class CollatzViewState(
    val enteredNumber: String = ""
)
