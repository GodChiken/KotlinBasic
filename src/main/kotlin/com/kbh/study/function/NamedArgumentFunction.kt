package com.kbh.study.function

fun main() {
    //named argument는 파라미터의 이름을 사용하여 직접 할당하는 방법이다.
    namedArgumentFunction("울면", destination = "당구장")
}

fun namedArgumentFunction(name: String, count: Int = 1, destination: String = "집") {
    println("$name, $count, $destination")
}