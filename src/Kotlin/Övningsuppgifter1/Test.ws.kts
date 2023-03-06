
fun demo(){
    println("Hello world")
}
demo()

fun hej () = println("Hello World as on liner")
hej()

fun giveMeFive() : Int {
    return 5
}

fun giveMeFiveShort () = 5

giveMeFive()

giveMeFiveShort()

fun area (h : Int,b : Int) = h*b
area(4 ,2)

fun eval (x : Int) = if (x<100) 4 else 42
println(eval(10))

fun brod(i : Int = 5) {
    if (i < 10)  println("You have access")
    else println("Access denied")
}
brod()










