package com.kbh.study.function.internal

/**
 * 사실 개인적으로 java8 stream api를 공부하고 실무에서도 활용한 터라 크게 거부감이 없으나
 * 코틀린에서 달라진점 추가된점을 확인해보려고한다.
 *
 * 자바에서 늘 해결 못했던점은 수천 개를 다루는 컬렉션의 경우 오버헤드의 이슈가 존재한다.
 * 코틀린에서 시퀀스를 활용하여 개선하는데 시퀀스는 내부 반복자다.
 *
 * 시퀀스는 실행을 지연시키며 반복이 꼭 필요한 부분에서 반복을 진행한다.
 * */

fun main() {
    val numberList = listOf(10, 12, 15, 17, 18, 19)
    for (i in numberList) {
        if(i % 2 == 0){
            print("$i, ")
        }
    }

    numberList.filter { e -> e % 2 == 0}
        .forEach { e -> print("$e, ")}

    val doubleList = mutableListOf<Int>()
    for (i in numberList){
        if(i % 2 == 0){
            doubleList.add(i * 2)
        }
    }
    println(doubleList)

    val doubleListByFilterAndMap = numberList.filter { e -> e % 2 == 0 }
        .map { e -> e * 2 }

    println(doubleListByFilterAndMap)
}