package Kotlin.Inlämningsuppgift

import java.io.File

data class Point(val x: Int, val y: Int)

enum class Direction {
    NORTH, EAST, SOUTH, WEST;

    fun turn(turn: Char): Direction {
        val values = values()
        val next = (ordinal + (if (turn == 'L') -1 else 1) + values.size) % values.size
        return values[next]
    }

    fun move(distance: Int): Point {
        return when (this) {
            NORTH -> Point(0, distance)
            EAST -> Point(distance, 0)
            SOUTH -> Point(0, -distance)
            WEST -> Point(-distance, 0)
        }
    }
}

fun main() {

    val input = File("src/Kotlin/Inlämningsuppgift/input2").readText().trim()
    val instructions = input.split(", ")

    var currentDirection = Direction.NORTH
    var currentLocation = Point(0, 0)
    val visitedLocations = mutableSetOf(currentLocation)

    var firstVisitedTwice: Point? = null

    for (instruction in instructions) {
        val turn = instruction[0]
        val distance = instruction.substring(1).toInt()

        currentDirection = currentDirection.turn(turn)
        val delta = currentDirection.move(distance)

        repeat(distance) {
            currentLocation = Point(currentLocation.x + delta.x, currentLocation.y + delta.y)

            if (firstVisitedTwice == null && currentLocation in visitedLocations) {
                firstVisitedTwice = currentLocation
            } else {
                visitedLocations.add(currentLocation)
            }
        }
    }

    val part1Distance = currentLocation.manhattanDistance()
    println("Part 1: $part1Distance")

    val part2Distance = firstVisitedTwice?.manhattanDistance()
    println("Part 2: $part2Distance")
}

fun Point.manhattanDistance(): Int {
    return Math.abs(x) + Math.abs(y)
}
