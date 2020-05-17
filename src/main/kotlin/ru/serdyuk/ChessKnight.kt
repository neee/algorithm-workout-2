package ru.serdyuk

@ExperimentalUnsignedTypes
class ChessKnight {

    fun number(pos: Int): ULong {
        val n = 1uL shl pos
        val l1 = 0xFEFEFEFEFEFEFEFEuL
        val l2 = 0xFCFCFCFCFCFCFCFCuL
        val r1 = 0x7F7F7F7F7F7F7F7FuL
        val r2 = 0x3F3F3F3F3F3F3F3FuL
        return (r2 and ((n shl 6) or (n shr 10))) or
            (r1 and ((n shl 15) or (n shr 17))) or
            (l1 and ((n shl 17) or (n shr 15))) or
            (l2 and ((n shl 10) or (n shr 6)))
    }
}

fun main() {
    print(ChessKnight().number(2))
}