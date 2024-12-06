sealed class MagicList(val startRange: Int) {
    data class DO(val start: Int) : MagicList(start)
    data class DONT(val start: Int) : MagicList(start)
    data class MATCH(val start: Int, val calc: String) : MagicList(start)
}

fun main() {

    val input = readInput("Day03")
    val multiplyStrings = mutableListOf<String>()
    val regex = "mul\\(\\d+,\\d+\\)".toRegex()
    val dontMatchRegex = "don\\'t\\(\\)".toRegex()
    val doMatchRegex = "do\\(\\)".toRegex()

    var part2Total = 0

    val magicList = mutableListOf<MagicList>()

    var ACTIVE = true

    var lineToParse = ""

    for (line in input) {
        lineToParse += line
    }

    val regexMatches = regex.findAll(lineToParse)
    val dontMatchRegexMatches = dontMatchRegex.findAll(lineToParse)
    val doMatchRegexMatches = doMatchRegex.findAll(lineToParse)

    for (donotMatch in dontMatchRegexMatches) {
        magicList.add(MagicList.DONT(donotMatch.range.last))
    }

    for (doMatch in doMatchRegexMatches) {
        magicList.add(MagicList.DO(doMatch.range.last))
    }

    for (match in regexMatches) {
        magicList.add(MagicList.MATCH(match.range.last, match.value))
    }

    magicList.sortBy { it.startRange }

    for (item in magicList) {
        when (item) {
            is MagicList.DO -> {
                ACTIVE = true
            }

            is MagicList.DONT -> {
                ACTIVE = false
            }

            is MagicList.MATCH -> {
                if (ACTIVE) {
                    multiplyStrings.add(item.calc)
                }
            }
        }
    }

    multiplyStrings.forEach { match ->
        val firstNumber =
            match.substringAfter("mul(").substringBefore(",").toInt()
        val secondNumber =
            match.substringAfter(",").substringBefore(")").toInt()

        part2Total = part2Total.plus(firstNumber * secondNumber)
    }

    "part2Total: $part2Total".println()
}
