package com.kbh.study.basic

/**
 * Java에서는 null safe하기에는 고민할게 많다. 이에 대한 대안으로 Optional이 나왔지만 세가지 문제가 있다.
 * 첫째, 개발자가 직접 사용해야하면 컴파일러가 강제하지 않는다.
 * 둘째, 대상으로 하는 객체가 없다면 작은 오버헤드가 발생한다.
 * 셋째, 개발자가 null을 리턴해도 별다른 경고가 없다.
 *
 * 이펙티브 자바에서 특정컬랙션 내에 리턴할게 없다면 비어있는 값으로 리턴해야한다 주장한다.
 * 그러나 객체를 리턴해야하는경우 어쩔 수 없이 null을 리턴하고 이를 Optional로 관리한다.
 * 코틀린에서 컴파일 단계에서 불가하게 하기때문에 좀 더 발전된 null safe를 추구할 수 있다.
 */
fun main() {
    val a: String? = null

    // null safe operator - ?.
    // 참조연산자를 실행하기 전에 null check
    println(a?.uppercase())

    // elvis operator - ?:
    // null check 이후 대체값을 활용
    println(a ?: "null".lowercase())

    // non-null operator - !!.
    // NPE 허용 연산자
    //println(a!!.toUpperCase())

    // 함수에도 활용이 가능하다.
    // NPE 체크를 위한 if 분기문보다 훨신 세련된 방법이다.
    "not null".run {
        println(uppercase())
        println(lowercase())
    }
}
