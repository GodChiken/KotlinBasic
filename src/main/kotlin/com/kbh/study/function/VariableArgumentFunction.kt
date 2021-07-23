package com.kbh.study.function

fun main() {
    // 가변인자를 코틀린에서 활용해봤다.
    variableArgumentFunction(1,2,3,4,5,6)
}

fun variableArgumentFunction(vararg numberArray:Int) {
    for (i in numberArray){
        println(i)
    }
}