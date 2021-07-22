package com.kbh.study.function.polymorphism

class Cola : Drink() {
    private var type = "콜라"
    override fun drink() {
        println("${name}중에 ${type}을 마십니다.")
    }

    fun washDishes() {
        println("${type}로 설거지를 합니다.")
    }
}