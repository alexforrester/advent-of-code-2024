fun main() {

    //val input = readInput("Day02_test")
    val input = readInput("Day03")

    val locationSize = input.size

    var part1Total = 0

    for (line in 0 until locationSize) {

        val lineToParse = input[line].also { println(it) }

        val regex = "mul\\(\\d+,\\d+\\)".toRegex()
        val regexMatches = regex.findAll(lineToParse).also { println(it) }
        val multiplyStrings = mutableListOf<String>()

        for (match in regexMatches) {
            multiplyStrings.add(match.value)
            match.value.also { println(it) }
        }

        multiplyStrings.forEach { match ->

            val firstNumber =
                match.substringAfter("mul(").substringBefore(",").toInt().also { println(it) }
            val secondNumber =
                match.substringAfter(",").substringBefore(")").toInt().also { println(it) }

            part1Total = part1Total.plus(firstNumber * secondNumber).also { println(it) }

        }

        "part1Total: $part1Total".println()
    }
}
