package com.kbh.study.collection.list

fun main() {
    //immutable 형태이므로 자식요소에 대한 변경이 불가하다.
    //val list: List<Int> = ArrayList()
    val a = listOf("사과", "딸기", "배")
    println(a[1])

    for (fruit in a) {
        println(fruit)
    }

    println()

    //mutable 형태이므로 자식요소에 대한 변경이 가능하다.
    //val list: MutableList<Int> = ArrayList()
    val b = mutableListOf(6, 3, 1)
    println(b)

    b.add(4)
    println(b)

    b.add(2, 8)
    println(b)

    b.removeAt(0)
    println(b)
}