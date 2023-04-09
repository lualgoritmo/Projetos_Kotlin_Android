package br.com.zup.desafirickmorth

fun main() {
//    testMatrix()
    test()
}

fun test() {
    val myList = listOf("apple","abacaxi","bacalhau","banana","bzinca", "cherry")
    val result = myList
        .filter { it.startsWith("b") }
        .map { it.uppercase() }
        .joinToString(", ")
    println(result)

}
data class Point(val x: Int, val y: Int)
fun testMatrix() {

    val matrix = arrayOf(
    arrayOf(Point(0, 0), Point(0, 1)),
    arrayOf(Point(1, 0), Point(1, 1)))

        for (row in matrix) {
            for (point in row) {
                println("(${point.x}, ${point.y})")
            }
        }

}


