package Kotlin

import java.io.File
import kotlin.math.abs

fun main() {
    // Skapa upp en textfil för att läsa in mina input string
    val filename = "src/Kotlin/Inlämningsuppgift/input2"

    // För att kunna läsa in textfilen med mina input string
    val instructions = File(filename).readText().trim().split(", ")

    // definiera variabler för att hålla reda på aktuell position och riktning.
    var x = 0
    var y = 0
    var direction = 0 // 0 = north, 1 = east, 2 = south, 3 = west

    // loopa igenom varje instruktion.
    for (instruction in instructions) {
        // bestäm vilken riktning du ska svänga åt och hur långt du ska flytta baserat på instruktionen.
        val turn = if (instruction[0] == 'R') 1 else -1
        val distance = instruction.substring(1).toInt()

        // uppdatera riktningen och flytta rätt avstånd.
        direction = (direction + turn + 4) % 4 // linda in riktningen om det behövs.
        when (direction) {
            0 -> y += distance
            1 -> x += distance
            2 -> y -= distance
            3 -> x -= distance
        }
    }

    // beräkna Manhattan-avståndet till den slutliga positionen.
    val distance = abs(x) + abs(y)

    println("The shortest path to the destination is $distance blocks.")


    }
