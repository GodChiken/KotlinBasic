package com.kbh.study.function

fun main() {
    // infix 함수를 만들어 활용해봤다.
    // 영어 문장을 만들듯, 프로그래밍 할 수 있을것 같다.
    println(6 multiplyWinnerScore 4 andPlusCooperation 5 scoreResult "점")
}

infix fun Int.multiplyWinnerScore(x: Int): Int = this * x
infix fun Int.andPlusCooperation(x: Int): Int = this + x
infix fun Int.scoreResult(x: String): String = String.format("%d %s", this, x)