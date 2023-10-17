package com.ballisticapps.collatzConjectureVisualizer.data
import java.math.BigInteger
class CollatzCalculator {
    private val oneBigInt = BigInteger("1")
    private val threeBigInt = BigInteger("3")

    fun createCollatzList(numEntered: BigInteger): List<BigInteger> {
        val collatzList = mutableListOf<BigInteger>()
        var currentNumber = numEntered

        collatzList.add(currentNumber)

        while (currentNumber.bitLength() > 1) {
            currentNumber = if (currentNumber.isOdd()) {
                currentNumber.multiply(threeBigInt).add(oneBigInt)
            } else {
                currentNumber.shiftRight(1)
            }
            collatzList.add(currentNumber)
        }

        return collatzList
    }

    private fun BigInteger.isOdd() = this.testBit(0)
}
