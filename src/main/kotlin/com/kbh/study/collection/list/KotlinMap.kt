package com.kbh.study.collection.list

fun main() {
    // key - value를 to keyword 를 통해 할당이 가능하다.
    val map = mutableMapOf("김보훈" to 34, "경화" to 37)

    // key - value 요소에 접근은 다음과 같다.
    for (entry in map){
        println("${entry.key} and ${entry.value}")
    }
}