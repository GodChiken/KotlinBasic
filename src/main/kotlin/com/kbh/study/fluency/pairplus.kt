package com.kbh.study.fluency

import kotlin.math.abs

/**
 * 연산자 오버로딩
 *
 * 자바에서 유저가 만든 데이터 타입에 연산자를 오버로딩해서 사용할 수 있는 권한은 없다.
 * 그러나 코틀린은 연산자 오버로딩이 가능한 언어다. 가능은 하나 확실한 경우가 아닐때 사용하면 혼란을 초기한다.
 *
 * 가령 날짜에 +2 를 한 경우, 일,월,년 중 얼마나 증가시켰는지 알기 어렵다.
 *
 * JVM에서 연산자 오버로딩을 제공하지 않는다. 코틀린에서 이를 처리하기 위해 특별히 명명된 메소드에 맵핑한다.
 *
 * 연산자를 오버로딩 하기 위해서 함수는 operator 키워드로 정의되어야한다.
 * */

operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>) =
    Pair(first + other.first, second + other.second)

fun main() {
    println(Pair(1,5).plus(Pair(900,5)))
}