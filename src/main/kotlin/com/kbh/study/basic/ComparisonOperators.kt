package com.kbh.study.basic

class ComparativeOperators {
    //is : 자료형 동일여부 파악, 형변환까지 자동으로 진행한다.
    fun isExample() {
        val a = "asdf"
        if (a is String) println(true)
    }

    // when : switch-case 문과 비슷하나 차이점 분명하다.
    // true 조건을 만나면 이후의 조건은 비교하지 않는다.
    // 등호 및 부등호는 사용이 불가능하다.
    // 조건문, 값을 반환하기 위한 방식이 존재하나 주관적인 의견으로 혼합하여 사용하는건 좋지 않아보인다.

    // 조건문 으로 활용하는 방식
    fun whenExampleConditionalSentence(a: Any) {
        when (a) {
            1 -> println("1")
            2 -> println("2")
            4 -> isExample()
            is String -> println(true)
            !is String -> println(false)
            else -> println("아무 조건에 해당되는 사항이 없다.")
        }
    }
    // 값을 반환하기 위하여 활용하는 방식
    fun whenExampleReturnValue(a: Any): Any {
        val result = when (a) {
            1 -> "아예 값으로 할당도 가능하다. 1"
            2 -> "아예 값으로 할당도 가능하다. 2"
            3 -> "아예 값으로 할당도 가능하다. 3"
            4 -> "아예 값으로 할당도 가능하다. 4"
            else -> println("아무 조건에 해당되는 사항이 없다.")
        }
        return result
    }
    // 축약형
    fun whenExampleReturnValue2(a: Any): Any {
        return when (a) {
            1 -> "아예 값으로 할당도 가능하다. 1"
            2 -> "아예 값으로 할당도 가능하다. 2"
            3 -> "아예 값으로 할당도 가능하다. 3"
            4 -> "아예 값으로 할당도 가능하다. 4"
            else -> println("아무 조건에 해당되는 사항이 없다.")
        }
    }
}

fun main() {
    val comparativeOperators = ComparativeOperators()
    comparativeOperators.isExample()
    comparativeOperators.whenExampleConditionalSentence(3)
    println(comparativeOperators.whenExampleReturnValue(4))
}