package com.kbh.study.function.lamda.inline

/**
 * inline 키워드를 사용하는 함수에서 다음과 같은 특징이 있다.
 * 특정한 이유에서 람다 호출을 최적화 하지 않고 싶은경우 noinline으로 가능하다.
 * 인라인 람수에서 호출한 람다가 논리컬 리턴을 사용이 가능하다.
 *
 * action1()에 전달된 람다에는 논리컬리턴과 라벨리턴을 허용, action2()에 전달된 람다에는 라벨리턴만 허용된다.
 * 이와 같은 이유는 인라인 람다는 함수 내에서 확장되었으나 인라인이 아닌 람다의 경우 다른 함수의 호출을 사용하기 때문이다.
 *
 * 클래스의 메소드나 속성 역시 inline으로 가능하다.
 * */

inline fun invokeTwo(
    n: Int,
    action1: (Int) -> Unit,
    noinline action2: (Int) -> Unit
): (Int) -> Unit {
    println("enter invokeTwo $n")
    action1(n)
    action2(n)
    println("exit invokeTwo $n")
    return {_: Int -> println("lamda returned from invokeTwo")}
}

fun callInvokeTwo() {
    invokeTwo(1, {i ->
        if(i == 1) { return }
        report(i)
    }, {i ->
        //if(i == 2) { return } : error
        report(i)
    })
}

fun report(n: Int) {
    println("")
    print("called with $n, ")
    val stackTrace = RuntimeException().stackTrace
    println("Stack depth: ${stackTrace.size}")
    println("Partial listin of the stack:")
    stackTrace.take(3).forEach(::println)
}



fun main(){
    callInvokeTwo()
}
