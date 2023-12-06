package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ballisticapps.collatzConjectureVisualizer.data.CollatzCalculator
import com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components.CollatzCalculatorEvent
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

    // StateFlow for enteredNumber and other state
    private val _collatzCalculatorState = MutableStateFlow(CollatzCalculatorState())
    val collatzCalculatorState: StateFlow<CollatzCalculatorState> =
        _collatzCalculatorState.asStateFlow()

    fun onEvent(event: CollatzCalculatorEvent) = viewModelScope.launch {
        when(event){
            is CollatzCalculatorEvent.CalculateCollatzNumber -> {
                _collatzCalculatorState.update { it.copy(collatzBigIntegerSequence = emptyList()) }
                computeCollatzSequence(
                    collatzCalculatorState.value.enteredNumber.toBigIntegerOrNull()
                        ?: BigInteger.ZERO)
            }
            is CollatzCalculatorEvent.EnteredNumber -> {
                _collatzCalculatorState.value = collatzCalculatorState.value.copy(
                    enteredNumber = event.value
                )
            }
        }
    }

    private fun computeCollatzSequence(numEntered: BigInteger) {
        viewModelScope.launch {
            val tempList = ArrayList<BigInteger>()
            collatzCalculator.createCollatzList(numEntered).collect { number ->
                tempList.add(number)
            }
            _collatzCalculatorState.update { state ->
                state.copy(
                    collatzBigIntegerSequence = tempList,
                    collatzTotalSteps = tempList.size - 1,
                    collatzTotalEven = tempList.count { it.testBit(0) },
                    collatzTotalOdd = tempList.count { !it.testBit(0) },
                    collatzEvenPercentage = (tempList.count { it.testBit(0) }.toFloat()
                            / tempList.size.toFloat()) * 100f,
                    collatzOddPercentage = (tempList.count { !it.testBit(0) }.toFloat()
                            / tempList.size.toFloat()) * 100f,
                    collatzMaximumIntSteps = tempList.indexOf(tempList.maxOrNull() ?:
                    BigInteger.ZERO),
                    collatzMaximumInt = tempList.maxOrNull() ?: BigInteger.ZERO,
                )
            }
        }
    }
}

data class CollatzCalculatorState(
    val enteredNumber: String = "",
    val collatzBigIntegerSequence: List<BigInteger> = emptyList(),
    val collatzTotalSteps: Int = 0,
    val collatzTotalEven: Int = 0,
    val collatzTotalOdd: Int = 0,
    val collatzEvenPercentage: Float = 0f,
    val collatzOddPercentage: Float = 0f,
    val collatzMaximumIntSteps: Int = 0,
    val collatzMaximumInt: BigInteger = BigInteger.ZERO
)
