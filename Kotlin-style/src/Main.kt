fun main() {
    //One expresion for function
    val result = { number1: Int, number2: Int -> number1 * number2 }

    println(result(3, 5))

    fun sum(number1: Int = 1, number2: Int = 2): Int = number1 + number2

    println(sum(32,65))
}