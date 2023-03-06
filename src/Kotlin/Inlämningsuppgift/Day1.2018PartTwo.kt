package Kotlin.Inlämningsuppgift

import java.io.File

fun main() {
    // Läser in input från filen
    val input = File("src/Kotlin/Inlämningsuppgift/input3").readLines()

    // Håll reda på alla frekvenser som hittills har setts.
    val seenFrequencies = mutableSetOf(0)

    // Initiera nuvarande frekvens till 0.
    var currentFrequency = 0

    // Loopa igenom frekvensändringarna tills en frekvens har setts två gånger.
    while (true) {
        for (line in input) {
            // Parsa frekvensändringen från inputen.
            val change = line.toInt()

            // Uppdatera nuvarande frekvens.
            currentFrequency += change

            // Kontrollera om den nuvarande frekvensen har setts tidigare.
            if (currentFrequency in seenFrequencies) {
                // Om den nuvarande frekvensen har setts tidigare, skriv ut den och returnera.
                println("First frequency reached twice: $currentFrequency")
                return
            }

            // Lägg till den nuvarande frekvensen i uppsättningen över sedda frekvenser.
            seenFrequencies.add(currentFrequency)
        }
    }
}
