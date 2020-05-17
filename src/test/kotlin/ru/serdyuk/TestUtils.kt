package ru.serdyuk

import org.junit.jupiter.params.provider.Arguments
import java.math.BigInteger
import java.nio.file.Files
import java.nio.file.Path
import java.util.ArrayList

class TestUtils

fun chessArguments(path: String): MutableList<Arguments> {
    var nr = 0
    val result: MutableList<Arguments> =
        ArrayList()
    while (true) {
        val inFile = Path.of(String.format("%s/test.%d.in", path, nr))
        val outFile = Path.of(String.format("%s/test.%d.out", path, nr))
        if (!Files.exists(inFile) || !Files.exists(outFile)) {
            break
        }
        val x = Files.readAllLines(inFile)[0].toInt()
        val y = Files.readAllLines(outFile)[0].toInt()
        val num = BigInteger(Files.readAllLines(outFile)[1])
        result.add(Arguments.of(x, y, num))
        nr++
    }
    return result
}
