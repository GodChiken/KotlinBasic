package com.kbh.study.`object`

/**
 * class 내부에 object를 기술하여 사용하는 companion object 를 학습한다.
 * 여러개의 인스턴스를 사용하면서 공통적으로 사용해야하는 프로퍼티와 함수를 정의하는데 사용된다.
 * 기존 자바에서 static member와 동일하다고 느껴질수 있으나 다르다.
 *
 * 컴패니언 객체는 인터페이스를 구현, 다른 클래스로 확장가능, 재사용에 유용한 점이 있다.
 * 서로 다른 인스턴스라고 하더라도 companion object 를 사용하면 아래 코드와 같은 활용이 가능하다.
 *
 * 멀티스레드인 경우 컴패니언 객체에 뮤터블 속성을 사용하면 스레드 안정성 문제를 발생되니 주의해야한다.
*/
fun main() {
    val a = FoodPoll("짜장")
    val b = FoodPoll("짬뽕")

    a.vote()
    a.vote()

    b.vote()
    b.vote()
    b.vote()

    println("${a.name} : ${a.count}")
    println("${b.name} : ${b.count}")
    println("총계 : ${FoodPoll.total}")

    // 만약 companion object에 이름을 지정하지 않고 직접적으로 접근해야하는경우 다음과 같이 접근할 수있다.
    //val foodPollSingleton = FoodPoll.Companion;
    // 혹은 다음과 같이 의미를 정한경우 해당 명명으로 접근이 가능하며 기존 Companion 으로 접근은 불가하다.
    val namedFoodPollSingleTon = FoodPoll.ForTotal
}

class FoodPoll(val name: String) {
    companion object ForTotal{
        var total = 0
    }

    var count = 0
    fun vote() {
        total++
        count++
    }
}