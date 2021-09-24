package com.kbh.study.basic

// 자바와 비교하여 코드량이 확연히 줄어들어 편리해졌다.
// 영어 문장을 기술하듯 작성하는 방식이 마음에 든다.
class Loop {
    fun forExample() {
        for (i in 0..10) {
            println(i)
        }
        for (i in 0..10 step 3) {
            println(i)
        }
        for (i in 9 downTo 0 step 3) {
            println(i)
        }
        for (i in 'a'..'z') {
            println(i)
        }
        for (i in 10 downTo 1) {
            println(i)
        }

        val nameList = listOf("A", "B", "C")
        for ((i, name) in nameList.withIndex()) {
            println("$name 은 $i 째 인덱스에 위치합니다.")
        }
    }
}

fun main() {
    val loop = Loop()
    loop.forExample()
}