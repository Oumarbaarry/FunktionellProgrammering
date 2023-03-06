package Kotlin.Inlämningsuppgift

import java.io.File

fun main() {
    // Läs in numren från input string och konvertera dem till Integer.
    val numbers = File("src/Kotlin/Inlämningsuppgift/input").readLines().map(String::toInt)

    // Hitta ett par av nummer som summerar till 2020 och skriv ut paret och deras produkt.
    val pair = findPairOfSum(numbers, 2020)
    println("Part 1: $pair")
    println(pair?.let { (x, y) -> x * y })

    // Hitta en triplet av nummer som summerar till 2020 och skriv ut tripletten och deras produkt
    val triple = findTripleOfSum(numbers, 2020)
    println("Part 2: $triple")
    println(triple?.let { (x, y, z) -> x * y * z })
}

// Funktion för att hitta en triplet av nummer i listan som summerar till ett givet nummer.
fun findTripleOfSum(numbers: List<Int>, sum: Int): Triple<Int, Int, Int>? {
    for (i in numbers.indices) { // Loopa igenom alla möjliga index i listan.
        for (j in i + 1 until numbers.size) { // Loopa igenom alla möjliga index efter I
            for (k in j + 1 until numbers.size) { // Loopa igenom alla möjliga index efter J
                if (numbers[i] + numbers[j] + numbers[k] == sum) { // Om summan av dessa tre tal är lika med det givna summan, returnera tripletten
                    return Triple(numbers[i], numbers[j], numbers[k])
                }
            }
        }
    }
    return null // Om ingen triplet hittas, returnera null
}

// Funktion för att hitta ett par av nummer i listan som summeras till ett givet nummer
fun findPairOfSum(numbers: List<Int>, sum: Int): Pair<Int, Int>? {
    for (i in numbers.indices) { // Loopa igenom alla möjliga index i listan
        for (j in i + 1 until numbers.size) { // Loopa igenom alla möjliga index efter I
            if (numbers[i] + numbers[j] == sum) {// Om summan av dessa två nummer är lika med det givna numret, returnera paret
                return Pair(numbers[i], numbers[j])
            }
        }
    }
    return null // Om inget par hittas, returnera null
}
