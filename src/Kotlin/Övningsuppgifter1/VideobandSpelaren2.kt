package Kotlin
fun main(){
    fun getLenght(startH : Int, startM : Int, stopH : Int, stopM : Int)=
    60*(startH-startM) + stopH - stopM

    fun lenghtLeft(HelaLen : Int , TaLen : Int) = HelaLen - TaLen

    fun doesVideoFit(lenVideo : Int, lenProgram : Int ) = if (lenVideo - lenProgram <=0) true else false

    fun enoughTime(HelaLenVideo: Int, taLenProgram: Int, startH: Int, startM: Int, stopH: Int, stopM: Int)=
            doesVideoFit(lenghtLeft(HelaLenVideo, taLenProgram),
                    getLenght(startH,startM,stopH,stopM))

    println(enoughTime(90, 30, 20, 0, 20, 30))
    println(enoughTime(90, 30, 20, 45, 21, 15))
    println(enoughTime(90, 30, 20, 30, 21, 15))
    println(enoughTime(90, 30, 20, 15, 21, 30))
    println(enoughTime(90, 80, 20, 0, 20, 30))


}

