package com.kbh.study.function.internal

/**
 * 사실 개인적으로 java8 stream api를 공부하고 실무에서도 활용한 터라 크게 거부감이 없으나
 * 코틀린에서 달라진점 추가된점을 확인해보려고한다.
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
}