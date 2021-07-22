package com.kbh.study.function.polymorphism

open class Drink {
    var name = "음료"
    open fun drink(){
        println("${name}을 마십니다.")
    }
}