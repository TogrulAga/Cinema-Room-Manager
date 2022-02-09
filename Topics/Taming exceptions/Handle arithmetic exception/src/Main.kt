fun main() {
    val (a, b) = List(2) { readln().toInt() }

    if (b == 0) {
        println("Division by zero, please fix the second argument!")
        return
    }

    println(a / b)
}