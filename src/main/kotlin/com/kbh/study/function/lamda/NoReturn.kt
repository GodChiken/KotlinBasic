package com.kbh.study.function.lamda

/**
 * 람다와 익명함수의 차이는 리턴에 있다.
 * 람다는 리턴값이 있어도 return 키워드를 가질 수 없다.
 *
 * 왜 인지 다음 코드로 최대한 파악한다면 명확하게 이해가 된다.
 *
 * 1. 람다에서 빠져나와서 invokeWith() 함수의 action(n) 이후의 나머지를 실행.
 * 2. for 루프 중단.
 * 3. caller() 중단.
 *
 * 세가지의 경우 중 무엇인지 파악이 안되기 때문에 허용되지 않는다.
 * 2가지의 경우만 예외적으로 허용이된다.
 *
 * 라벨 리턴(labeled, 명시적)과 논리컬 리털(non-local, 비지역적)이다.
 *
 * */

fun invokeWith(n: Int, action: (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

fun caller() {
    (1..3).forEach {i ->
        invokeWith(i) {
            println("enter for $it")
            //if(it == 2) {return} // 람다에서 키워드가 불허
            println("exit for $it")
        }
    }
    println("end of caller")
}

fun main(){
    caller()
    println("after return from caller")
}