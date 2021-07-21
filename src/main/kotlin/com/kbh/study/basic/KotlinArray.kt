package com.kbh.study.basic

class KotlinArray {
    // 코틀린에서 배열을 생성하는 함수이다.
    var intArray = arrayOf(1, 2, 3, 4)
    // 미리 특정한 크기의 배열을 선언하고자 할때 다음과 같은 방법을 활용한다.
    var nullArray = arrayOfNulls<Int>(5)
}

fun main() {
    val kotlinArray = KotlinArray()
    print(kotlinArray.intArray)
    print(kotlinArray.intArray[0])
}