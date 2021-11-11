package com.kbh.study.function.lamda

/**
 * callerNonLocalReturn() 내의 라벨 리턴과 다르게 처음 등장하는 리턴은 caller() 함수를 빠져나간다
 * 이것을 논리컬 리턴이라 부른다. 왜 forEach에서는 허용이 되는건지는 확인해보면 inline이라느 키워드 때문이다.
 *
 * return 키워드를 정리하면 다음과같다.
 * 기본적으로 람다에서 불허하고 라벨리턴을 사용하면 현재 동작 중인 람다를 스킵할 수 있다.
 * 논로컬 리턴을 사용하면 현재 동작중인 람다를 선언한곳 바깥으로 나갈 수 이싸. 하지만 람다를 받는 함수가 inline으로 선언된 경우에 가능하다.
 *
 * */

fun invokeWithNonLocalReturn(n: Int, action: (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

fun callerNonLocalReturn() {
    (1..3).forEach { i ->
        println("in forEach for $i")
        if (i == 2) {
            return
        }
        invokeWithNonLocalReturn(i) here@{
            println("enter for $it")
            if (it == 2) {
                return@here
            }
            println("exit for $it")
        }
    }
    println("end of caller")
}

fun main() {
    callerNonLocalReturn()
    println("after return from caller")
}