package ru.serdyuk

@ExperimentalUnsignedTypes
class FenNotation {

    fun translateFromFen(fen: String): Array<ULong> {
        val fenLines = fen.split("/")
        val array = Array(Piece.values().size) { 0uL }
        fenLines.reversed()
            .forEachIndexed { lineNumber, line ->
                var pos = 0
                line.forEach { char ->
                    if (char.isDigit()) {
                        pos += char.toString().toInt()
                    } else {
                        calculateAmountPiece(array, Piece.from(char), lineNumber, pos)
                        pos++
                    }
                }
            }
        return array
    }

    private fun calculateAmountPiece(array: Array<ULong>, piece: Piece, lineNumber: Int, pos: Int) {
        array[piece.ordinal] += 1uL shl (lineNumber * 8 + pos)
    }
}

enum class Piece(private val declaration: Char) {
    WHITE_PAWNS('P'),
    WHITE_KNIGHTS('N'),
    WHITE_BISHOPS('B'),
    WHITE_ROOKS('R'),
    WHITE_QUEENS('Q'),
    WHITE_KING('K'),
    BLACK_PAWNS('p'),
    BLACK_KNIGHTS('n'),
    BLACK_BISHOPS('b'),
    BLACK_ROOKS('r'),
    BLACK_QUEENS('q'),
    BLACK_KING('k'),
    /**/;

    companion object {
        fun from(declaration: Char) = values().first { it.declaration == declaration }
    }
}

@ExperimentalUnsignedTypes
fun main() {
    val fen = "7k/8/8/8/8/8/8/K7"
    println(FenNotation().translateFromFen(fen).contentToString())
}
