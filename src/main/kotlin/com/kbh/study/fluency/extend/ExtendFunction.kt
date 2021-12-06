package com.kbh.study.fluency.extend


/**
 * Java8 에서 함수인터페이스 Function<T, R> 두개의 함수를 조합하기 위해 andThen() 메소드를 가지고 있고 이 기능을 이용해서 연산을 합치는데 사용한다.
 * 코틀린의 Function 은 andThen()를 가지고있지 않지만, 인젝트는 가능하다.
 *
 * T -> R, R -> U 순서로 받고 리턴을 하는 구조다.
 *
 * 2개의 단독함수, increment, double 를 만들어서 정의한 확장 함수를 사용해보자.
 *
 * */

fun <T, R, U> ((T) -> R).andThen(next: (R) -> U): (T) -> U =
    { input: T -> next(this(input))}

fun increment(number: Int): Double = number + 1.toDouble()
fun double(number: Double) = number * 2

fun main() {
    val incrementAndDouble = ::increment.andThen(::double)
    println(incrementAndDouble(5))
}