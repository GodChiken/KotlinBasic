package com.kbh.study.function

fun main() {
    defaultArgumentFunction("짬뽕")
    defaultArgumentFunction("짜장", 2, "당구장")
}

// 함수에 별다른 값을 파라미터로 넘기지 않아도 작동해야되는 경우라면 다음과 같이 파라미터에 디폴트 값을 할당할 수 있다.
// 개인적으론 사용하지 않고 함수 내부에서 처리를 하든 오버로딩해서 처리할 것이다.
fun defaultArgumentFunction(name: String, count: Int = 1, destination: String = "집") {
    println("$name, $count, $destination")
}