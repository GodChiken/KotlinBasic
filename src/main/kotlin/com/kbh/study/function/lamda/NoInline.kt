package com.kbh.study.function.lamda

/**
 * 람다는 함수에서 함수로 넘겨주기 용의하나 포퍼먼스상에서 주의사항이 있다.
 * inline 키워드는 람다를 사용해서 호출 오버헤드를 제거하고 성능을 향상시킨다.
 * inline 람다는 논로컬 흐름의 제어를 위해 사용되고 구체화된 타입 파라미터르 전달하는 용도로 사용된다.
 *
 * 예제에선 Stack Depth는 31이나 현 2021-11-11에서 실행했을때 7이다.
 * inline 키워드를 쓰게되면 callInvokeTwo()함수에서 invokeTwo() 바이트코드를 확장했다.
 * 하여 콜스택이 3개가 줄어들게된다.
 *
 * 호출에 대한 오버헤드를 제거할 수있으나 inline 함수 자체가 큰 함수라면 오히려 바이트 코드가 많아지게 되버리므로
 * 측정을 하고 적용하자.
 * */

fun invokeTwo(
    n: Int,
    action1: (Int) -> Unit,
    action2: (Int) -> Unit
): (Int) -> Unit {
    println("enter invokeTwo $n")
    action1(n)
    action2(n)
    println("exit invokeTwo $n")
    return {_: Int -> println("lamda returned from invokeTwo")}
}

fun callInvokeTwo() {
    invokeTwo(1, {i -> report(i)}, {i -> report(i) })
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
