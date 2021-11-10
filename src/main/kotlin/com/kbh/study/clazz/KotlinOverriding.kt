package com.kbh.study.clazz

fun main() {
    val human = Human()
    val programmer = Programmer()
    val designer = Designer()
    human.eat()
    programmer.eat()
    designer.eat()
}


open class Human {
    open fun eat() {
        println("각자의 방식으로 먹는다.")
    }
}

class Programmer : Human() {
    override fun eat(){
        println("정크푸드와 커피를 먹는다.")
    }
}

class Designer : Human() {
    override fun eat(){
        println("보양식을 먹는다.")
    }
}