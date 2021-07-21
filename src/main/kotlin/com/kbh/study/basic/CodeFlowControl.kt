package com.kbh.study.basic

class CodeFlowControl {
    // label
    // 여러 중첩된 반복문에서 특정 loop 를 기점으로 하여 'break' or 'continue' 를 수행하고자 할때
    // '라벨명@' 을 붙여 특정 loop 를 지정하고 '제어문@라벨명' 을 통해서 제어한다.
    fun labelExample() {
        first@ for (i in 1..10) {
            for (j in 1..10) {
                if (i == 1 && j == 3) break@first
                println("i : $i, j: $j")
            }
        }
    }
}

fun main() {
    val codeFlowControl = CodeFlowControl()
    codeFlowControl.labelExample()
}