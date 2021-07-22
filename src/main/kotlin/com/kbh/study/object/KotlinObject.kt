package com.kbh.study.`object`

// 생성자 없이 객체를 만드는 키워드 'object' 를 학습한다.
// 'class' 와의 차이점은 어러개의 인스턴스가 아닌 공통적인 속성과 함수를 사용해야하는 경우 사용한다.
// 일종의 'Singleton Pattern'을 언어차원에서 지원한다.
object Counter {
    var count = 0

    fun countUp(){
        count++
    }

    fun clear(){
        count = 0
    }
}
fun main() {
    println(Counter.count)
    Counter.countUp()
    Counter.countUp()
    println(Counter.count)
    Counter.clear()
    println(Counter.count)
}