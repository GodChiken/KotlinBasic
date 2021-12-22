package com.kbh.study.recursion

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

fun main() {
    println(sort(listOf(12,5,15,12,8,19)))
}