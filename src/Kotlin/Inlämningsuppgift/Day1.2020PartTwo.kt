package Kotlin.Inlämningsuppgift

import java.io.File

fun main() {
    val filename = "src/Kotlin/Inlämningsuppgift/input"  // Här är min input file

    val inputList = mutableListOf<Int>() // skapa en mutable list för att lagra input values.

    File(filename).useLines { lines -> lines.forEach { inputList.add(it.toInt()) } } // läs input values från filen och lägg till dem i listan.

    val n = inputList.size // Få ut numrena från input values

    for (i in 0 until n - 2) { // loopa igenom input values förutom de två sista
        for (j in i + 1 until n - 1) { // loopa igenom resterande input values förutom den sista
            for (k in j + 1 until n) { // loopa igenom resterande input values
                if (inputList[i] + inputList[j] + inputList[k] == 2020) { // Kolla ifall summan av de 3 värderna från input values blir 2020
                    println("The three numbers that add up to 2020 are ${inputList[i]}, ${inputList[j]}, and ${inputList[k]}.")
                    println("Their product is ${inputList[i] * inputList[j] * inputList[k]}.") // Om Ja, Skriv ut de tre värdena och deras produkt
                    return // Avsluta programmet efter första hittade triplet som plussas ihop till 2020
                }
            }
        }
    }
    println("There are no three numbers in the input that add up to 2020.") // Skriv ut det här meddelandet ifall ingen triplet från input values matchar 2020
}
