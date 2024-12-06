
fun main() {

    val input = readInput("Day03")
    val multiplyStrings = mutableListOf<String>()
    val regex = "mul\\(\\d+,\\d+\\)".toRegex()

    var part1Total = 0

    var lineToParse = ""

    for (line in input) {
        lineToParse += line
    }

    val regexMatches = regex.findAll(lineToParse)

    for (match in regexMatches) {
        multiplyStrings.add(match.value)
    }

    multiplyStrings.forEach { match ->
        val firstNumber =
            match.substringAfter("mul(").substringBefore(",").toInt()
        val secondNumber =
            match.substringAfter(",").substringBefore(")").toInt()

        part1Total = part1Total.plus(firstNumber * secondNumber)
    }

    "part1Total: $part1Total".println()
}
