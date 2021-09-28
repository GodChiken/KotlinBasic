package com.kbh.study.collection

fun main() {
    //immutable 형태이므로 자식요소에 대한 변경이 불가하다.
    //val list: List<Int> = ArrayList()
    val fruitList = listOf("사과", "딸기", "배")
    println(fruitList[1])

    for (fruit in fruitList) {
        println(fruit)
    }

    println()

    //mutable 형태이므로 자식요소에 대한 변경이 가능하다.
    //val list: MutableList<Int> = ArrayList()
    val numberList = mutableListOf(6, 3, 1)
    println(numberList)

    numberList.add(4)
    println(numberList)

    numberList.add(2, 8)
    println(numberList)

    numberList.removeAt(0)
    println(numberList)

    /**
     * 이뮤터블은 잘 알다시피 변경이 불가하다.
     * 코틀린의 리스트 인터페이스는 자바의 Arrays.asList()로 만든 JDK 객체의 뷰로 동작한다. (객체의 뷰가 무슨말인지 잘 모르겠다.)
     * Collection -> _Arrays -> _ArraysJvm에 들어가보면 add()가 포합되어있지 않다.
     * 그렇기 때문에 일반적인 방법으로 변경이 불가하다.
     * "+"를 사용하게되면 이뮤터블 리스트를 활용하여 새로운 리스트를 가질 수 있다.
     * 논리적인 접근으로 따져보면 이에 반대되는 "-"도 존재한다.
     * */

    val fruitList2 = fruitList + "포도"
    val fruitList3 = fruitList - "사과"
    println(fruitList2)
    println(fruitList3)
}