package com.kbh.study.fluency.inject

import java.net.URL

/**
 * 코틀린에서 개발자가 다른 JVM 언어에서 작성된 클래스를 포함한 모든 클래스의 속성과 메서드를 인젝팅이 가능하고
 * 인젝션을 런타임 패치나 클래스 로딩없이 수행한다.
 *
 * 클래스와 상속 불가한 클래스 역시 확장에는 열려있다.
 * 확장하려는 함수의 바이트 코드에 변동이 없다.
 *
 * 클래스에 이미 존재하는 메서드를 확장함수로 만드는경우 멤버함수의 우선순위가 더 높으므로 무의미한 짓이다..
 * */

data class Point(val x: Int, val y: Int)
data class Circle(val cx: Int, val cy: Int, val radius: Int)

/**
 * Property Injecting - 확장 속성을 이용한 인젝팅
 *
 * 확장 속성역시 인젝팅을 활용할 수 있다. 확장 속성은 클래스 내부에 존재하지 않으므로 백킹 필드를 가질 수 없다.
 * field 에 접근이 불가능하다.
 * */
val Circle.area: Double
    get() = kotlin.math.PI * radius * radius

/**
 * Method Injecting - 확장 함수을 이용한 메소드 인젝팅
 *
 * Circle class에 점 안의 위치를 찾기위한 contains()를 인젝팅 해본다.
 * 코틀린의 확장함수는 패키지의 static method로 만들어진다.
 * 또한 public 메서드와 속성에만 접근이 가능하다.
 * */
//fun Circle.contains(point: Point) =
//    (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) <
//            radius * radius

/**
 * Operator Injecting - 확장 함수을 이용한 연산자 인젝팅
 *
 * 가령 확장 함수를 통한 메서드 인젝팅시 이에 대응되는 연산자에도 허용하고 인젝팅을 하고싶은 경우가 있다.
 * 가령 예제에서 우리는 점이 원안에 있는지 여부를 가지고 문제를 해결한다.
 * in, contains() 두가지로 해석이 가능하고 뜻은 동일하다.
 * 다만 연산자에도 허용해야 하는경우는 operator 키워드를 기술하면 끝이다.
 * */
/*operator fun Circle.contains(point: Point) =
    (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) < radius * radius*/

/**
 * Infix(중위표기) Operator Injection
 *
 * 여타 다양한 코드를 보면, 점과 괄호의 난무로 인하여 가독성이 떨어지는 경우가 있다.
 * infix는 이 경우 해법이 될 수 있으며, '.' 와 띄어쓰기를 통한 표현이 모두 가능하므로 함수에 보다 유연성을 줄 수 있다.
 *
 * 그러나 단점은 하나의 파라미터만 받아야하며 가변인자와 기본파라미터도 사용이 불가하다.
 * */


operator infix fun Circle.contains(point: Point) =
    (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) < radius * radius

/**
 * third party class injecting
 *
 * 서드파티 클래스, 혹은 이미 존재하는 메서드로 확장함수를 라우팅이 가능하다.
 * */
fun String.isPalindrome(): Boolean {
    // 회문 여부확인, 앞으로 읽으나 뒤로 읽으나 똑같은지..
    return reversed() == this
}
fun String.isFuck(): Boolean {
    return "Fuck" == this
}

// 코드블럭 대신
fun String.shout() = uppercase()

/**
 * iterator() 메소드를 클래스로 인젝팅시 도움되는 사항
 *
 * 반복자를 만들떄 익명객체로 만들 수 있다. (객체 표현식으로 사용하는 익명객체)
 * start 속성을 이용하여 range 첫번째 요소에 접근이 가능하고 ClosedRange<T> 클래스의 endclusive를 이용하여 마지막 요소에 접근할 수 있다.
 * >= 사용시 compareTo() 실행된다.
 * 뮤터블 String을 사용하기 위해 StringBuilder룰 활용.
 *
 * */

operator fun ClosedRange<String>.iterator() =
    object : Iterator<String> {
        private val next = StringBuilder(start)
        private val last = endInclusive
        override fun hasNext() =
            last >= next.toString() && last.length >= next.length

        override fun next(): String {
            val result = next.toString()
            val lastCharacter = next.last()
            if (lastCharacter < Char.MAX_VALUE) {
                next.setCharAt(next.length - 1, lastCharacter + 1)
            } else {
                next.append(Char.MIN_VALUE)
            }
            return result
        }
    }

/**
 * static method injecting
 *
 * 클래스의 companion object를 확장해서 static method를 인젝팅할 수있다.
 * 즉 클래스가 companion object를 가지고 있다면 전재가 성립되어야한다.
 *
 * */
fun String.Companion.toURL(link: String) = URL(link)

fun main() {
    val circle = Circle(100,100,25)
    val point1 = Point(110,110)
    val point2 = Point(10,100)

    println(circle.contains(point1))
    println(circle.contains(point2))
    println(circle contains point2)
    println(point1 in circle)
    println(point2 in circle)
    println("Area is ${circle.area}")

    val dad = "dad"
    println(dad.isPalindrome())
    println(dad.shout())
    println("Fuck".isFuck())

    for (word in "hell".."help"){
        print("$word, ")
    }

    val url : URL = String.toURL("https://pargprog.com")
}