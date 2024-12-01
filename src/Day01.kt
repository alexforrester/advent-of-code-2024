import kotlin.math.abs

fun main() {

    //val input = readInput("Day01_test")
    val input = readInput("Day01")
    input.println()

    val locationSize = input.size

    val locationIds =
        input.map { it.substringBefore(" ").toInt() }.toMutableList().also { it.println() }
    val locations =
        input.map { it.substringAfter(" ").trim().toInt() }.toMutableList().also { it.println() }

    var part1Total = 0

    for (line in 0 until locationSize) {

        val smallestLocationId = locationIds.min()
        val smallestLocation = locations.min()

        val difference = abs(smallestLocationId - smallestLocation)

        part1Total += difference

        locationIds.remove(smallestLocationId)
        locations.remove(smallestLocation)
    }

    "Total $part1Total".println()

    var part2Total = 0

    val locationIdsPart2 =
        input.map { it.substringBefore(" ").toInt() }.toMutableList().also { it.println() }
    val locationsPart2 =
        input.map { it.substringAfter(" ").trim().toInt() }.toMutableList().also { it.println() }

    locationIdsPart2.forEach { locationId ->

        val countLocationIds = locationsPart2.count { it == locationId }

        val simlarityScore = locationId * countLocationIds

        part2Total += simlarityScore

    }

    "Total $part2Total".println()

}
