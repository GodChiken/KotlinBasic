package com.kbh.study.fluency.inject

/**
 * 기존 Point 클래스를 가공하여 내부에서 Pair<Int, Int>로 확장함수를 인젝팅했다.
 * 클래스 외부에서 사용하려는 경우 컴파일 에러가발생한다.
 *
 * 확장함수는 내부에서 생성됬기 때문에 디스패치, 익트텐션 리시버를 가진다.
 *
 * this@InnerInjecting : 디스패치 리시버, 확장함수가 추가된 클래스의 인스턴
 * this : 익스텐션 리시버, 확장함수를 리시브하여 실행되는 객체
 *
 * 확장함수에서 언금된 속성 혹은 메서드가 익스텐션 리시버 Pair에 있는경우 익스텐션 리시버를 사용한다.
 * -> 익스텐션 리시버에에 언급된 프로퍼티 또는 메서드가 없다면
 * -> 디스패치 리시버를 확인하고
 * -> 디스패치 리시버에 해당하는 메서드나 프로퍼티가 있다면 바인딩된다.
 *
 *
 * */

class InnerInjecting (x: Int, y: Int){
    private val pair = Pair(x,y)
    private val firstsign = if (pair.first < 0) "" else "+"
    private val secondsign = if (pair.second < 0) "" else "+"

    override fun toString() = pair.point2String()
    fun Pair<Int, Int>.point2String()
        = "(${firstsign}${first}, ${this@InnerInjecting.secondsign}${this.second})"
}

fun main() {
    println(InnerInjecting(1, -3))
    println(InnerInjecting(-3, -4))
}