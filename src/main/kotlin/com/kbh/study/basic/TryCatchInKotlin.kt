package com.kbh.study.basic

/**
 * 코틀린에서는 자바에서 하던 오류에 대해 확실히 catch, throw 는 할필요가 없다.
 * checked, unchecked 상관없이 오류 발생시 적합한 exception 을 호출된 곳으로 전달된다.
 * 가령 Java Thread 내 sleep() 의 경우 컴파일러가 명시적예외를 반드시 처리하도록 강제한다.
 * 그러므로 모든 sleep() 은 try-catch 구조를 취할 수 밖에 없다.
 *
 * 코틀린 컴파일러를 사용하면 이러한 점을 강제하지 않음으로 프로그램 구현에 있어 요구사항을 줄여 유연성을 제공한다.
 * 안전한 방어적 프로그래밍을 고수한다면, 기존처럼 풀어나가도 좋다.
 * */
class TryCatchInKotlin

fun main() {
    println("1234")
    Thread.sleep(1000)
    println("5678")
}