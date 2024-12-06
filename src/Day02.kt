import kotlin.math.abs

fun main() {

    val input = readInput("Day02")

    val locationSize = input.size

    var totalReports = 0
    var part1 = 0

    for (line in 0 until locationSize) {

        val report = input[line].split(" ").map(String::toInt).also { it.println() }

        if (standardParsing(report)) {
            (totalReports++).also { it.println() }
            part1++
        }
       else if (removeDigits(report)) {
            (totalReports++).also { it.println() }
        }
    }
    "Total Reports Part 1: $part1".println()
    "Total Reports Part 2: $totalReports".println()
}

private fun standardParsing(report: List<Int>) = isIncrementing(report) || isDecrementing(report)

private fun removeDigits(report: List<Int>) : Boolean {

           for (index in 0 until report.size) {
               val newList = report.toMutableList()
               newList.removeAt(index)
               if (standardParsing(newList)) return true
           }

            return false
}

fun isIncrementing(report: List<Int>): Boolean {

    var number = report.first()

    for (i in 1 until report.size) {
        var current: Int = report[i]

        if (!(current > number && (current - number) < 4)) {
            return false
        }
        number = current
    }

    return true
}

fun isDecrementing(report: List<Int>): Boolean {

    var number = report.first()

    for (i in 1 until report.size) {
        var current: Int = report[i]

        if (!(current < number && (number - current) < 4)) {
            return false
        }
        number = current
    }

    return true
}
