package com.ballisticapps.collatzConjectureVisualizer.data
import dagger.Module
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.math.BigInteger

/**
 * An implementation for computing the Collatz sequence for a given number.
 *
 * The Collatz sequence is a mathematical sequence where the next term is obtained from the
 * previous term as follows: if the previous term is even, the next term is one half of the previous term.
 * If the previous term is odd, the next term is 3 times the previous term plus 1.
 * The sequence always ends with the numbers 4, 2, 1.
 *
 * @property oneBigInt Constant value representing the number 1 as a BigInteger.
 * @property threeBigInt Constant value representing the number 3 as a BigInteger.
 *
 * @sample createCollatzList Uses the provided BigInteger value to generate and return the Collatz sequence.
 */
@Module
class CollatzCalculator {
    private val oneBigInt = BigInteger("1")
    private val threeBigInt = BigInteger("3")

    /**
     * Generates the Collatz sequence for the provided number using Flow.
     *
     * @param numEntered The starting number for which the Collatz sequence is to be computed.
     * @return A flow emitting each number in the Collatz sequence starting from the provided number.
     */
    fun createCollatzList(numEntered: BigInteger): Flow<BigInteger> = flow {
        var currentNumber = numEntered
        emit(currentNumber)

        while (currentNumber.bitLength() > 1) {
            currentNumber = if (currentNumber.testBit(0)) {
                currentNumber.multiply(threeBigInt).add(oneBigInt)
            } else {
                currentNumber.shiftRight(1)
            }
            emit(currentNumber)
        }
    }
}
