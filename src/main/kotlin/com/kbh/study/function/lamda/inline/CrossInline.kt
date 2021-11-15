package com.kbh.study.function.lamda.inline

/**
 * 인라인이라 생각했던 람다가 실제로 인라인이 아닌경우가 존재한다.
 * 함수가 인라인으로 마크되었다면, 노인라인으로 마크되지 않은 람다 파라미터는 인라인으로 간주된다.
 * 만약에 주어진 람다를 다른 함수로 전달하거나 콜러에게 다시 돌려줘야하는 경우는 어떻게 해결하는지 고민이된다.
 *
 * 람다가 호출되는 경우가 아니라면 noinline을 추가하면 되나 호출될지 아닐지 모를경우에 inline으로 만들고 싶은경우
 * 호출한 쪽으로 인라인을 전달하도록 함수에게 요청할 수 있다. 이것이 크로스인라인이다.
 *
 * invokeTwoByErrorExample을 살펴보면,
 * action1()과 같이 직접 호출하는경우 인라인이 될 수 있다.
 * action2()와 같이 직접호출되지 않고 람다에 포함되 호출되버리면 인라인이 될수없다.
 *
 * 두가지 방법으로 action2()를 마크하여 해결이 가능하다.
 * noinline : action2()의 호출은 인라인이 될 수 없다. 성능상 이득이없고 전달되는 람다에 논리컬 리턴을 사용할 수 없다.
 * crossinline : action2()는 호출되는 부분에서 인라인이 된다.
 *
 * invokeTwoByCrossinline
* */

/*inline fun invokeTwoByErrorExample(
    n: Int,
    action1: (Int) -> Unit,
    action2: (Int) -> Unit
): (Int) -> Unit {
    println("enter invokeTwo $n")
    action1(n)
    println("exit invokeTwo $n")
    return { input: Int -> action2(input) }
}*/

inline fun invokeTwoByCrossinline(
    n: Int,
    action1: (Int) -> Unit,
    crossinline action2: (Int) -> Unit
): (Int) -> Unit {
    println("enter invokeTwo $n")
    action1(n)
    println("exit invokeTwo $n")
    return { input: Int -> action2(input) }
}

fun callInvokeTwoByCrossinline() {
    invokeTwo(1, {i ->
        if(i == 1) { return }
        reportByCrossinline(i)
    }, {i ->
        //if(i == 2) { return } : error
        reportByCrossinline(i)
    })
}

fun reportByCrossinline(n: Int) {
    println("")
    print("called with $n, ")
    val stackTrace = RuntimeException().stackTrace
    println("Stack depth: ${stackTrace.size}")
    println("Partial listin of the stack:")
    stackTrace.take(3).forEach(::println)
}



fun main(){
    callInvokeTwoByCrossinline()
}
