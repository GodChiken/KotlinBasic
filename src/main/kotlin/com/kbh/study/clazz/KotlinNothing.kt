package com.kbh.study.clazz

/**
 * 리턴 값이 없는경우 void 키워드르 사용하곤한다. expression이 리턴을 하지않는경우 Unit를 void 대신 사용된다.
 * 함수가 아무런 결과를 않는 경우가 존재한다 이럴경우 Nothing 클래스가 필요하다.
 * Nothing 클래스는 값이나 결과가 영원히 존재하지 않는 다는 것을 의미한다.
 * 자바에서는 Object 하나만 존재한다면 코틀린에서는 Any, Nothing 으로 관리된다.
 * Nothing 또한 모든 클래스로 대체될 수 있으나 차이점은 컴파일러가 프로그램의 타입 무결성을 검증하는 용도로 사용된다.
 * */
fun main() {
    computeSqrt(1.1)
}

fun computeSqrt(n: Double): Double {
    if (n >= 0) {
        return Math.sqrt(n)
    } else {
        throw RuntimeException("No negative please")
    }
}