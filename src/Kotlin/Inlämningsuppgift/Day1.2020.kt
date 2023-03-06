package Kotlin.Inlämningsuppgift

import java.io.File

fun main() {
    val filename = "src/Kotlin/Inlämningsuppgift/input"  // Här är min input file

    val inputList = mutableListOf<Int>() // skapa en mutable list för att lagra input values.

    File(filename).useLines { lines -> lines.forEach { inputList.add(it.toInt()) } } // läs input values från filen och lägg till dem i listan.

    val n = inputList.size // Få ut numrena från input values

    for (i in 0 until n - 1) { // loopa igenom input values förutom den sista
        for (j in i + 1 until n) { // loopa igenom resterande input values
            if (inputList[i] + inputList[j] == 2020) { // Kolla ifall summan av de 2 värderna från input values blir 2020
                println("The two numbers that add up to 2020 are ${inputList[i]} and ${inputList[j]}.")
                println("Their product is ${inputList[i] * inputList[j]}.") // Om Ja, Skriv ut de två värdena och deras produkt
                return // Avsluta programmet efter första hittade par som plussas ihop till 2020

            }
        }
    }
    println("There are no two numbers in the input that add up to 2020.") // Skriv ut det här meddelandet ifall inget par från input values matchar 2020

}
