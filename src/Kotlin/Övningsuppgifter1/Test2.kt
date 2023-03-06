package Kotlin

fun main(){
    class Person(var name:String)
    val person1 = Person("Pelle")
    println(person1.name)

    person1.name = "Jocke"
    println(person1.name)


}
