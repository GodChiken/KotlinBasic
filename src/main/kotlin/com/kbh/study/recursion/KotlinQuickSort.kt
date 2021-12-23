package com.kbh.study.recursion

import java.math.BigInteger

/**
 * sort(), factorialRec(), factorialIterative() 모두 같은 기능을 하나
 * factorialIterative()은 반복문을 활용하여 해결하는 프로시저이다.
 *
 * sort(), factorialRec()는 재귀적으로 문제를 해결하는 프로시저이고 재귀 프로세서로 컴파일 및 실행이 된다.
 * 그러나 입력사이즈가 클 경우 stackOverFlow 문제가 발생하므로 꼬리호출의 최적화를 해야한다.
 * <컴퓨터 프로그램의 구조와 해석(인사이트, 2016)>에서 "재귀는 반복 프로세스로 컴파일 될 수 있다." 라는 내용에 따르면
 * 코드를 재귀로 작성하고 런타임시 반복으로 수행하기에 stackOverFlow가 발생하지 않는 구조를 취할 수 있다.
 *
 * */

fun sort(numberList: List<Int>): List<Int> =
    if (numberList.isEmpty()) {
        numberList
    } else {
        val pivot = numberList.first()
        val tail = numberList.drop(1)
        val lessOrEqual = tail.filter {e -> e<= pivot}
        val larger = tail.filter { e -> e > pivot }
        sort(lessOrEqual) + pivot + sort(larger)
    }

tailrec fun factorialRec(n: Int): BigInteger =
    if (n <= 0) 1.toBigInteger() else n.toBigInteger() * factorialRec(n - 1)

// fold() : 람다와 함께 초기값을 받는 점을 제외하면 reduce()와 동일하다.
fun factorialIterative(n: Int): BigInteger =
    (1..n).fold(BigInteger("1")) { product, e -> product * e.toBigInteger()}

fun main() {
    println(sort(listOf(12,5,15,12,8,19)))
    println(factorialRec(5))
    println(factorialIterative(5))
}