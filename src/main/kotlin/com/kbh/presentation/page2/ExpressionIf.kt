package com.kbh.presentation.page2

//코틀린에서의 if문은 참인지 거짓인지 판별한 이후 값을 만들어내지 않는 문(statement)이 아니라 값을 생성하는 식(expression) 이다.
fun main() {
    val score = 100
    val result = if (score == 100) {
        "용돈 1000억"
    } else {
        "빚 1조"
    }
    println(result)
}