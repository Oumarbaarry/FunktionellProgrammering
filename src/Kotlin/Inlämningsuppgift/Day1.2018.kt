package Kotlin.Inlämningsuppgift

import java.io.File

fun main() {
    // Läser in input från filen
    val input = File("src/Kotlin/Inlämningsuppgift/input3").readLines()

    // Initiera startfrekvensen till 0.
    var frequency = 0

    // Loopa igenom alla rader av inputen
    for (line in input) {

        // Omvandla linje till en Integer( frekvens ändringar)
        val change = line.toInt()

        // Uppdatera frekvensen genom att lägga till förändringen.
        frequency += change
    }

    // Skriv ut resultat frekvensen
    println("Resulting frequency: $frequency")
}
