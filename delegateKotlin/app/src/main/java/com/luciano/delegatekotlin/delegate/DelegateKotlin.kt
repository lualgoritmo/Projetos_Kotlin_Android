package com.luciano.delegatekotlin.delegate

fun main() {
    val delegate = delegateTwo()
    println(delegate.first())
    println(delegate.getFrase())
    println(delegate.numberTwo())
    println(delegate.numberOne())
    println("-----------------------------")
    val delegateTwo = delegateTwo()
    println(delegateTwo.numberTree())
    println("---------------------------------------")

    val delegateString = delegateTwo()
    println("Nome:")
    delegateString.name()
    println("Get Frase")
    delegateString.getFrase()
    println("Inteiro")
    println(delegateString.first())
    println("Primeiro Número")
    println(delegateString.numberOne())
    println("Segundo Número")
    println(delegateString.numberTwo())
    println("Terceiro Número")
    delegateString.numberTree()
    println("-------------------------")
    println("Usando com o by lazy")
    println(teste.first())
    println(teste.name())
    println(teste.getFrase())
    println(teste.numberOne())
    println(teste.numberTree())
}
interface returnString {
    fun name()
    fun getFrase()
    fun first(): Int
}
interface numberInt {
    fun numberOne():Int
    fun numberTwo():Int
    fun numberTree()
}
class ReturnStringImpl(): returnString, numberInt {
    override fun name() = println("Luana Gostosa")
    override fun getFrase() = println("A volta dos que não foram")
    override fun first(): Int = 44
    override fun numberOne(): Int = 1
    override fun numberTwo(): Int = 2
    override fun numberTree() = println("3")
}
val teste by lazy {  ReturnStringImpl() }

class DelegateString: returnString by ReturnStringImpl()

class delegateTwo: returnString by ReturnStringImpl(), numberInt by ReturnStringImpl()