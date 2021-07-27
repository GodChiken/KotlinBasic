package com.kbh.study.variable.lazy

/**
 * 코틀린에서 객체의 선언과 동시에 할당을 하지 않으면 사용할수 없으나 경우에 따라서 객체를 나중에 할당해야하는 경우도 있다.
 * lateinit 키워드를 통해 가능하다. 기본 자료형에서는 사용이 불가능하나, String 클래스는 예외이다.
 * '::' 더블 콜론 연산자를 통해 참조 가능한 코틀린 Lazy 인터페이스 내의 isInitialized울 사용하여 초기화가 되었는지 확인 가능하다.
 */
fun main() {
    val lateInitSample = LateInitSample()
    println(lateInitSample.getLateInitText())
    lateInitSample.text = "할당해주마"
    println(lateInitSample.getLateInitText())
}

class LateInitSample {
    lateinit var text: String
    fun getLateInitText(): String {
        // return 에 이어서 바로 활용한 점이 확인됬으나 이럴거면.. 삼항연산자를 허가해주면 어떨지 아쉽다.
        return if (::text.isInitialized) {
            text
        } else {
            "기본값"
        }
    }
}