package ru.serdyuk

@ExperimentalUnsignedTypes
class ChessKing {

    fun result(x: Int): Pair<Int, ULong> {
        val number = number(x)
        return count(number) to number
    }

    fun number(x: Int): ULong {
        val n = 1uL shl x
        val l = n and 0xFEFEFEFEFEFEFEFEuL
        val r = n and 0x7F7F7F7F7F7F7F7FuL
        return (l shl 7) or (n shl 8) or (r shl 9) or (l shr 1) or (r shl 1) or (l shr 9) or (n shr 8) or (r shr 7)
    }

    fun count(number: ULong): Int {
        var value = number;
        var count = 0
        while (value > 0uL) {
            value = value and (value - 1uL)
            count++
        }
        return count
    }
}

@ExperimentalUnsignedTypes
fun main() {
    val number = ChessKing().number(55)
    val count = ChessKing().count(number)
    println("$number $count")
}