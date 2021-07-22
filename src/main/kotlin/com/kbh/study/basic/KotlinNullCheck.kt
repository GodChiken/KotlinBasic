package com.kbh.study.basic

fun main() {
    val a: String? = null

    // null safe operator - ?.
    // 참조연산자를 실행하기 전에 null check
    println(a?.toUpperCase())

    // elvis operator - ?:
    // null check 이후 대체값을 활용
    println(a ?: "null".toUpperCase())

    // non-null operator - !!.
    // NPE 허용 연산자
    //println(a!!.toUpperCase())

    // 함수에도 활용이 가능하다.
    // NPE 체크를 위한 if 분기문보다 훨신 세련된 방법이다.
    "not null".run{
        println(toUpperCase())
        println(toLowerCase())
    }
}
