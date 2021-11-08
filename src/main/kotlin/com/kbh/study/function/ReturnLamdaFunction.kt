package com.kbh.study.function

/**
 * 람다식을 활용해서 결과를 리턴하는 법은 좋으나 때로는 동일한 코드를 새로 작성해버리는 경우가 있다.
 * 이런 경우를 Write Every Time(WET) 라 불리는 안티패턴이다.
 * 아래 예제에서는 람다를 리턴하는 방식으로 좀 더 개선할 수 있다.
 *
 * 블록 바디 함수에서 리턴 시, 항시 리턴 타입을 명시해야하며, 타입추론은 리턴할 함수가 블록바디가 아닌경우에만 사용하라.
 * */

val names = listOf("P", "PAT", "PAUL", "PAULa")

/*fun predicateOfLength(length: Int): (String) -> Boolean {
    return { input: String -> input.length == length}
}*/

// predicateOfLength 도 타입 추론을 통해 조금 더 개선.
fun predicateOfLength(length: Int) = { input: String -> input.length == length }


fun main() {
    //println(names.find {name -> name.length == 5})
    //println(names.find {name -> name.length == 4})
    println(names.find(predicateOfLength(5)))
    println(names.find(predicateOfLength(4)))
}