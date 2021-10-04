package com.kbh.study.basic

/**
 * 객체의 타입을 체크하는것은 필수적이나, 확장성 면에서 고려하여 최소한으로 하애한다.
 * 이유는 새로운 타입이 체크될 때마다 개방 폐쇠의 원칙에도 위배되기 때문이다.
 *
 * 실행시간에 타입을 체크해야하는 경우는 다음 2가지 이다.
 * equals() : 현재 가지고있는 개체가 해당 클래스의 인스턴스인지 알아야 구현할 수 있다.
 * when : 분기가 인스턴스 타입에 기반하여 이루어지는경우
 *
 * is 키워드를 사용하여 모든 Animal 클래스의 인스턴스를 동일하게 취급하도록 오버라이드 한다.
 */
fun main() {
    val greet: Any = "hello"
    val animal: Any = Animal()
    val animal2: Any = Animal()

    println(animal == animal2)
}


class Animal {
    override operator fun equals(other: Any?) = other is Animal
    // 혹은 아래와같이 부정형으로도 사용할 수 있다.
    //override operator fun equals(other: Any?) = other !is Animal
}