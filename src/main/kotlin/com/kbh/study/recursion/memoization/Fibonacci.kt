package com.kbh.study.recursion.memoization

import kotlin.system.measureTimeMillis

/**
 * 클래스를 활용하여 지난연산의 결과를 저장해서 사용할 수도 있으나, 순수 함수내에서 다뤄서 해보려한다.
 *
 * 함수호출 시 캐시를 체크해 데이터가 존재하는지 확인하고 없으면 함수를 호출하는 식으로 설계해야한다.
 * 그러나 함수의 호출이 함수에 바인드 되어야하고 조건로직을 구현하기 어렵다.
 * 람다 표현식, 클래스나 함수에 메소드를 인젝팅 하는 방식을 활용하여 이 문제를 해결할 수 있다.
 *
 * 람다 표현식을 활요한 함수이므로 fib()를 람다표현식 안에서 호출하고 있으므로 fib라는 변수를
 * 람다 표현식 안에서 정의가 불가하다. lateinit을 사용하여 지연할당을 지정해준다.
 *
 * memoize() 함수는 주어진 람다 표현식을 받아 내부의 original에 저장하고 새로운 람다 표현식을 리턴한다.
 * 리턴된 람다표현식은 fib변수에 저장이된다.
 *
 * 파라미터 하나만 사용하는 모든함수에 사용이 가능하나 장단점이 존재한다.
 * 코드가 비교적 간결해지나 fib를 먼저 정의하고 그 이후에 람다 표현식을 할당해야한다.
 *
* */

/*fun fib(n: Int) : Long = when (n) {
    0,1 -> 1L
    else -> fib(n - 1) + fib(n - 2)
}*/

fun <T, R> ((T) -> R).memoize(): ((T) -> R) {
    val original = this
    val cache = mutableMapOf<T, R>()
    return { n: T -> cache.getOrPut(n) { original(n) } }
}

lateinit var fib: (Int) -> (Long)

fun main() {
    fib = { n: Int ->
        when (n) {
            0, 1 -> 1L
            else -> fib(n - 1) + fib(n - 2)
        }
    }.memoize()

    println(measureTimeMillis { fib(40) })
    println(measureTimeMillis { fib(45) })
}