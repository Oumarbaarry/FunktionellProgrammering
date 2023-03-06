package Kotlin.Inlämningsuppgift

import java.io.File

fun main() {
    // Skapa upp en textfil för att läsa in mina input string
    val input = File("src/Kotlin/Inlämningsuppgift/input2").readText().trim()

    // Dela upp input string med ", "för att få en lista med riktningar.
    val directions = input.split(", ")

    // Definiera variabler för att hålla reda på den aktuella positionen och riktningen.
    var x = 0
    var y = 0
    var direction = 0 // 0 - North, 1 - East, 2 - South, 3 - West

    // Skapa en uppsättning för att hålla reda på besökta koordinater.
    val visited = mutableSetOf<Pair<Int, Int>>()

    // Loopa över listan med riktningar.
    for (d in directions) {
        val turn = d[0]
        val distance = d.substring(1).toInt()

        // Uppdatera riktningen baserat på svängen.
        if (turn == 'R') {
            direction = (direction + 1) % 4
        } else {
            direction = (direction + 3) % 4
        }

        // Rör i det angivna avståndet i den nuvarande riktningen.
        for (i in 1..distance) {
            when (direction) {
                0 -> y++
                1 -> x++
                2 -> y--
                3 -> x--
            }

            //Här skriver jag ut uträkningen för första plasten som besöks 2 ggr o hur många blocks ifrån.
            val coordinate = Pair(x, y)
            if (visited.contains(coordinate)) {
                val distance = Math.abs(x) + Math.abs(y)
                println("First location visited twice is $coordinate, which is $distance blocks away.")
                return
            }

            visited.add(coordinate)

        }
    }}

