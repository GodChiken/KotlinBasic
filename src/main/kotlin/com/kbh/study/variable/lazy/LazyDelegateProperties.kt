package com.kbh.study.variable.lazy

/**
 * 변수를 사용하는 시점까지 초기화를 늦춰주는 방식을 Lazy Delegate Properties 라고한다.
 * 코드상에서는 변수를 즉시 생성 및 할당하는 형태로 보이니 실제 실행시 사용되는 시점에서 초기화를 진행하므로 코드 실행시간을 향상시킬 수 있다.
 * 람다함수 형태로 초기화가 진행된다.
 * */
fun main() {
    val number: Int by lazy {
        println("초기화 진행")
        7
    }
    println(number)
    println(number)
}