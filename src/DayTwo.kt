import java.io.BufferedReader
import java.io.File


fun readFile(fileName: String): List<String> {
    val bufferedReader: BufferedReader = File(fileName).bufferedReader()
    return bufferedReader.readLines()
}

fun main() {
    partOne()
    partTwo()
}

fun partOne() {
    val input = readFile("input/day_two.txt")
    var horizontalPosition: Int = 0
    var depthPosition: Int = 0

    for (line in input) {
        val direction = parseDirection(line)
        val distance = parseDistance(line)

        when (direction) {
            "forward" -> horizontalPosition += distance
            "down" -> depthPosition += distance
            "up" -> depthPosition -= distance
        }
    }

    println(horizontalPosition * depthPosition)
}

fun partTwo() {
    val input = readFile("input/day_two.txt")
    var horizontalPosition: Int = 0
    var depthPosition: Int = 0
    var aim: Int = 0

    for (line in input) {
        val direction = parseDirection(line)
        val distance = parseDistance(line)

        when (direction) {
            "forward" -> {
                horizontalPosition += distance
                depthPosition += distance * aim
            }
            "down" -> aim += distance
            "up" -> aim -= distance
        }
    }

    println(horizontalPosition * depthPosition)
}

fun parseDirection(line: String): String {
    return line.substringBefore(" ")
}

fun parseDistance(line: String): Int {
    return line.substringAfter(" ").toInt()
}
