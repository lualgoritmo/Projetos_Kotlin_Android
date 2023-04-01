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
    println(teste.numberTwo())
    println(teste.numberTree())

    println("Usando todas com o by lazy")
    println(teste2.first())
    println(teste2.name())
    println(teste2.getFrase())
    println(teste2.numberOne())
    println(teste2.numberTwo())
    println(teste2.numberTree())
}

interface returnString {
    fun name()
    fun getFrase(): String
    fun first(): Int
}

interface numberInt {
    fun numberOne(): Int
    fun numberTwo(): Int
    fun numberTree()
}

class ReturnStringImpl() : returnString, numberInt {
    override fun name() = println("Luana Gostosa 1")
    override fun getFrase(): String = "A volta dos que não foram 2"
    override fun first(): Int = 44
    override fun numberOne(): Int = 1
    override fun numberTwo(): Int = 2
    override fun numberTree() = println("3 String")
}

val teste by lazy { ReturnStringImpl() }

class DelegateString : returnString by ReturnStringImpl()

class delegateTwo : returnString by ReturnStringImpl(), numberInt by ReturnStringImpl()

val teste2 by lazy { ReturnStringImpl() }
