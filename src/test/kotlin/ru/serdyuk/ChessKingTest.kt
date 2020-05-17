package ru.serdyuk

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.IOException
import java.math.BigInteger

@ExperimentalUnsignedTypes
internal class ChessKingTest {

    @ParameterizedTest
    @MethodSource("provideKingTestValues")
    fun test1(x: Int, y: Int, num: BigInteger) {
        val result = ChessKing().result(x)
        Assertions.assertEquals(y to num.toULong(), result)
    }

    companion object {

        @JvmStatic
        @Throws(IOException::class)
        private fun provideKingTestValues(): List<Arguments> {
            val path = "src/test/resources/0.BITS/1.Bitboard - Король"
            return chessArguments(path)
        }
    }
}
