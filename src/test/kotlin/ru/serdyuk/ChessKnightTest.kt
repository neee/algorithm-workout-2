package ru.serdyuk

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.IOException
import java.math.BigInteger

@ExperimentalUnsignedTypes
internal class ChessKnightTest {

    @ParameterizedTest
    @MethodSource("provideKingTestValues")
    fun test1(x: Int, y: Int, num: BigInteger) {
        val result = ChessKnight().number(x)
        Assertions.assertEquals(y to num.toULong(), result.countBits() to result)
    }

    companion object {

        @JvmStatic
        @Throws(IOException::class)
        private fun provideKingTestValues(): List<Arguments> {
            val path = "src/test/resources/0.BITS/2.Bitboard - Конь"
            return chessArguments(path)
        }
    }
}
