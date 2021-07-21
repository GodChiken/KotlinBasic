package com.kbh.study.scope

// 각 프로그래밍 언어 안에서 구성요소(변수, 함수, 클래스)를 서로 공유하거나 제한하기 위한 것을 의미한다.
// 코틀린에서 새로은 접근제한자 `internal`이 추가되었고, 스코프를 모듈내에서 제한하는 역활을 한다.

// package - public, internal, private 는 전체, 모듈, 파일로 접근 범위를 제한한다. protected 은 최상위 스코프에서 사용되지 않는다.
class KotlinScope {
    internal val a = 1
}
//protected val a:Int = 1 -- 사용불가
private fun foo() { } // 파일 내에서만 접근가능
public var bar: Int = 5 // 어디서나 프로퍼티에 접근이 가능하고 `public`은 생략가능하다.
private set         // 파일 내에서만 접근가능
internal val baz = 6    // 같은 모듈내에서 접근 가능

// class
// public - 전체
// private - 내부에섭 볼수있으고 하위클래스에서도 볼수없다.
// protected - 내부에섭 볼수있으고 하위클래스에서도 볼수있다.
// internal - 모듈 내에서 가능하다.
open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4
    protected class Nested { public val e: Int = 5 }
}
class Subclass : Outer() {
    // a - 접근불가
    // b, c, d - 접근가능
    // Nested and e - 접근가능
    override val b = 5   // protected 이므로 변경도 사용도 불가하다.
}
class Unrelated(outer: Outer) {
    // outer.a, outer.b 접근이 불가하다
    // outer.c outer.d 같은 모듈내에서 접근 가능하다
    // Outer.Nested, Nested::e 접근불가
}