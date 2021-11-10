package com.kbh.study.function.lamda

/**
 * 라벨 리턴은 람다의 흐름을 제어해서 라벨 블록으로 점프하기 위해서 만들어졌다.
 * 람다를 빠져나가는 것을 의미한다. 어떻게 보면 continue와 동일하다.
 *
 * 암시적, 명시적 라벨 리턴중 명시적 라벨리턴이 권장된다. 의도가 명확하게 보이기 때문이다.
 *
 * */

fun invokeWithLabeledReturn(n: Int, action: (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

// 명시적 라벨의 활용법
fun callerLabeledReturn() {
    (1..3).forEach {i ->
        invokeWithLabeledReturn(i) here@ {
            println("enter for $it")
            if(it == 2) {
                return@here
            }
            println("exit for $it")
        }
    }
    println("end of caller")
}

// 암시적 라벨의 활용법
fun callerImplicitLabeledReturn() {
    (1..3).forEach {i ->
        invokeWithLabeledReturn(i) {
            println("enter for $it")
            if(it == 2) {
                return@invokeWithLabeledReturn
            }
            println("exit for $it")
        }
    }
    println("end of caller")
}

fun main(){
    callerLabeledReturn()
    println("after return from caller")
}