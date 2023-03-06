package Kotlin

fun main(){
    for (i in 1..20){
        if (i%2==0){
            println("even numbers "+i)
        }
    }

    fun printMultiplication(table: Int, start: Int, stop: Int){
        for (x in start..stop) println(table * x)
    }
    printMultiplication(10,1,20)
}