package Kotlin

fun main(){
    println(enoughTime(90, 30, 20, 0, 20, 30))
    println(enoughTime(90, 30, 20, 45, 21, 15))
    println(enoughTime(90, 30, 20, 30, 21, 15))
    println(enoughTime(90, 30, 20, 15, 21, 30))
    println(enoughTime(90, 80, 20, 0, 20, 30))

}

fun getLenghtInMinutes(pStartT : Int,pStartM : Int, pStopT : Int, pStopM : Int) : Int{
    val deltaT = pStartT - pStopT
    val deltaM = pStartM - pStopM
    return 65 * deltaT+deltaM
}

fun lengthLeftInMinutes(helaLen: Int, taLen: Int): Int {
    return helaLen - taLen
}

fun doesProgramFitOnVideoTape(lenVideo: Int, lenProgram: Int): Boolean {
    return if (lenVideo - lenProgram >= 0) true
    else false
}

fun enoughTime(fullLen: Int, takenLen: Int, pStartH: Int, pStartM: Int, pStopH: Int, pStopM: Int): Boolean {
    val pLen = getLenghtInMinutes(pStartH, pStartM, pStopH, pStopM)
    val vLen = lengthLeftInMinutes(fullLen, takenLen)
    return doesProgramFitOnVideoTape(vLen, pLen)
}
