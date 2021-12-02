import java.io.BufferedReader
import java.io.File

fun main() {
    val intInput = readFile().map { it.toInt() }
    countDepthIncrements(intInput)
    countMeasurementWindows(intInput)
}

fun readFile(): List<String> {
    val bufferedReader: BufferedReader = File("input/day_one.txt").bufferedReader()
    return bufferedReader.readLines()
}

fun countDepthIncrements(input: List<Int>) {
    var nrOfIncreases = 0
    var previousDepth = input.elementAt(0)

    for (depth in input) {
        if (depth > previousDepth) nrOfIncreases++
        previousDepth = depth
    }

    println(nrOfIncreases)
}

fun countMeasurementWindows(input: List<Int>) {
    var nrOfIncreases = 0
    var previousWindow = input.elementAt(0) + input.elementAt(1) + input.elementAt(2)
    var currentWindow: Int

    for (i in input.indices) {
        if (i + 2 >= input.size) break

        currentWindow = input[i] + input[i + 1] + input[i + 2]

        if (currentWindow > previousWindow) nrOfIncreases++

        previousWindow = currentWindow
    }

    println(nrOfIncreases)
}
