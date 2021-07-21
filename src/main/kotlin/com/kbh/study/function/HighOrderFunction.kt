package com.kbh.study.function

fun a(str: String) {
    println("$str 함수 a 입니다.")
}
// 다른 함수를 인자로 받거나 리턴하는 함수를 high order function 이라 불리운다.
fun b(function: (String) -> Unit) {
    function("b가 호출한")
}

fun main() {
    //high order function 형태로 넘기려면 :: 를 붙여 사용한다.
    b(::a)
}