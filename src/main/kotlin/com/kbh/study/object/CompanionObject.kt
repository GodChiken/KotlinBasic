package com.kbh.study.`object`

// class 내부에 object를 기술하여 사용하는 companion class 를 학습한다.
// 여러개의 인스턴스를 사용하면서 공통적으로 사용해야하는 프로퍼티와 함수를 정의하는데 사용된다.
// 기존 자바에서 static member와 동일하다.
// 서로 다른 인스턴스라고 하더라도 companion object 를 사용하면 아래 코드와 같은 활용이 가능하다.
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
}

class FoodPoll(val name: String) {
    companion object {
        var total = 0
    }

    var count = 0
    fun vote() {
        total++
        count++
    }
}