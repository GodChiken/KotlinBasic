package com.kbh.study.fluency.any

/**
 * 람다는 하나의 리시버만 가진다. 그러나 중첩 레벨에 따라서 변수에 바인딩하기위한 다중 스코프를 가질 수 있다.
 *
 * 클래스 내부에서 인잭팅을 배울 때 클래스 안에서 확장함수를 사용한것은 리시버를 사용하는 것과 유사하다.
 * 중첩클래스와 이너클래스를 배울 때 확인했던 이너클래스의 리시버와 유사하다.
 *
 * 두 케이스 모두 외부 리시버를 this@OuterClassName 을 활용해서 참조했다.
 * 람다 표현식도 마찬가지로 람다를 감싸고 있는 것은 클래스가 아니라 함수이기 때문에 this@OuterFunctionName 문법을 사용해서 외부 스코프를 참조할 수 있다.
 *
 * top(), nested() 함수를 정의하고 두 함수는 리시버를 포함한 람다 표현식을 파라미터로 받도록 한다.
 * 그리고 각각의 함수는 전달받은 타깃 컨텍스느 혹은 리시버 객체에서 람다 표현식을 실행한다.
 *
 * 이너 혹은 가장 가까운 리시버와 외부 혹은 부모 리시버에 모두 접근할 수 있는 기능은 강력하다.
 * 또한 이너 클래스, 메서드 확장, 리시버를 이용하는 람다와 함께 사용할 때 조화로운 기능이다.
 * */

fun top(func: String.() -> Unit) = "hello".func()
fun nested(func: Int.() -> Unit) = (-2).func()

fun main() {
    top {
        println("In Outer lamda $this and ${length}")
        nested {
            println("in inner lamda $this and ${toDouble()}")
            println("from inner through receiver of outer: ${length}")
            println("from inner to receiver ${this@top}")
        }
    }
}