package com.kbh.study.recursion.memoization.delegate

import kotlin.reflect.KProperty
import kotlin.system.measureTimeMillis

/**
 * 지난 시간 코틀린에서 메모이제이션하는 방법 중 Groovy 방식을 살펴보았으나 단점이 존재했다.
 * 이번에는 델리게이트의 프로퍼티와 지역변수에 접근할 수 있는 점을 활용해서 메모이제이션을 할것이다.
 * PoliteString.kt에서 학습시 배웠던 특징을 다시 상기해야 이해가 가능하다.
 *
 * 델리게이트용으로 만든 클래스 Memoize는 내부적으로 캐시를 가지고 있고,
 * this 는 func 프로퍼티를 가지고 있다.
 * getValue() 함수가 값이 캐시에 없을 경우 오리지널 함수를 실행시키는 람다 표현식을 리턴한다.
 *
 * fib 변수에 한번만 할당할 것이므로 setValue()는 필요가 없다.
 * 또한 델리게이트로 위임하여 접근하는 것이기 때문에 컴파일러에 lateinit과 같은 키워드를
 * 안해도된다.
 *
 * */

class Memoize<T,R>(val func: (T) -> R) {
    val cache = mutableMapOf<T,R>()
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = { n: T ->
        cache.getOrPut(n) { func(n) }
    }
}

val fib: (Int) -> Long by Memoize {n: Int ->
    when (n) {
        0, 1 -> 1L
        else -> fib(n - 1) + fib(n - 2)
    }
}

fun main() {
    println(measureTimeMillis { fib(40) })
    println(measureTimeMillis { fib(45) })
    println(measureTimeMillis { fib(500) })
}