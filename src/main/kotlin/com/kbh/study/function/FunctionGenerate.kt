package com.kbh.study.function

/**
 * 코틀린은 함수를 정의시 Kiss(Keep it Simple, Stupid) 원칙을 준수한다
 * 단순하게 방해요소 없이 수행에 있어 실수가 없도록 정의하는 원칙이다.
 *
 **/
fun main() {
    println("The Message Result $message")
}

fun kissFunction() = "kiss"

// 컴파일시 리턴타입이 추론되어 구지 정의할 필요는 없으나 외부에서 사용되거나 좀 복잡해진다면 다음과 같이 리턴타입을 명확하게 기술하자
// 그래야만 다른 인터페이스의 구현에 의해서 다른타입으로 변경되는 것을 방지 할 수 있다.
fun greet(): String = "Hello"

// 코틀린에서는 모든 함수를 표현식으로 취급하기 위해서 Unit 을 활용하여 의미있게 추후 프로세스를 위해 사용할 수 있게 되있다
fun sayHello(): Unit = println("hello")
val message: Unit = sayHello()