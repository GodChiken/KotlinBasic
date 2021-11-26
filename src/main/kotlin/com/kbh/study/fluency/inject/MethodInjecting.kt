package com.kbh.study.fluency.inject

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
 * Circle class에 점 안의 위치를 찾기위한 contains()를 인젝팅 해본다.
 * 코틀린의 확장함수는 패키지의 static method로 만들어진다.
 * 또한 public 메서드와 속성에만 접근이 가능하다.
 * */
fun Circle.contains(point: Point) =
    (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) <
            radius * radius

fun main() {
    val circle = Circle(100,100,25)
    val point1 = Point(110,110)
    val point2 = Point(10,100)
    println(circle.contains(point1))
    println(circle.contains(point2))
}