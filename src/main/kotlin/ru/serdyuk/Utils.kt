package ru.serdyuk

import java.math.BigInteger

class Utils

@ExperimentalUnsignedTypes
fun ULong.countBits(): Int {
    var count = 0
    var temp = this
    while (temp > 0uL) {
        count++
        temp = temp and (temp - 1uL)
    }
    return count
}

@ExperimentalUnsignedTypes
fun BigInteger.toULong() = toString().toULong()