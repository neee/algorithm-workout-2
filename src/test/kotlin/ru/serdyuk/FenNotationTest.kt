package ru.serdyuk

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@ExperimentalUnsignedTypes
internal class FenNotationTest {

    @ParameterizedTest
    @MethodSource("testValues")
    fun test(fen: String, expected: List<String>) {
        val actual = FenNotation().translateFromFen(fen)
        Assertions.assertIterableEquals(expected.map { it.toULong() }, actual.toList())
    }

    companion object {

        @JvmStatic
        fun testValues(): List<Arguments> {
            val path = "src/test/resources/0.BITS/3.Bitboard - FEN"
            return chessArgumentsFen(path)
        }
    }
}
