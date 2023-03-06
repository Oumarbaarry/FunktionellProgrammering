package Kotlin.Övningsuppgifter1


class Djur (Sort: String, antalBen : Int){
    var antalBen : Int = antalBen
        get()=field
        set(value){
            field=value
        }
    var Sort : String = Sort
        get()=field
        set(value){
            field=value
        }
    fun printantalBen(){
        println(antalBen)
    }
    fun printSort(){
        println(Sort)
    }
    fun printEverything(){
        println("Jag är en $Sort med $antalBen ben " )
    }
}
    fun main(){
        val d1 = Djur("Lejon",4)
        val d2 = Djur("Tiger",4)
        val d3 = Djur("Häst",4)
        val d4 = Djur("Pingvin",2)
        val d5 = Djur("Kangaroo",2)

        val DjurLista = listOf<Djur>(d1,d2,d3,d4,d5)
        DjurLista.forEach(Djur::printEverything)

        var Lejon = Djur("Lejon",4)
        var Pingvin = Djur("Pingvin",2)
        var Häst = Djur("Häst",4)
        var Tiger = Djur("Tiger",4)
        var Kangaroo = Djur("Kangaroo",2)

        val set1 = setOf(Lejon,Pingvin,Häst,Tiger,Kangaroo)
        val set2 = setOf(Pingvin,Häst,Kangaroo)
        val set3 = setOf(Häst,Lejon)

        set1.forEach({e -> e.printEverything()})
        println(set1.equals(set2))
        println(set1.equals(set3))

    }



