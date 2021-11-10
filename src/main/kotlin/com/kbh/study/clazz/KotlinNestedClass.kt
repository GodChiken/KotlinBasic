package com.kbh.study.clazz

// kotlin에서의 Nested Class 는 상위 클래스 내에 하위 클래스가 연관이 되어있다는 점을 이야기 하는 것일뿐
// 외부 클래스의 구성요소를 공유하지 못한다. 중첩 클래스 자체로 객체를 생성할 수 있다.
fun main() {
    val egg:Nest.Egg = Nest.Egg()
    //println(egg.size)
    println(egg.eggSize)
}
class Nest {
    val size:Int = 100

    class Egg{
        // Nest의 size 접근 불가 - val capacity = size / eggSize
        val eggSize:Int = 10
    }
}