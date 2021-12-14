package com.kbh.study.function

/**
 * 람다식을 활용해서 결과를 리턴하는 법은 좋으나 때로는 동일한 코드를 새로 작성해버리는 경우가 있다.
 * 이런 경우를 Write Every Time(WET) 라 불리는 안티패턴이다.
 * 아래 예제에서는 람다를 리턴하는 방식으로 좀 더 개선할 수 있다.
 *
 * 블록 바디 함수에서 리턴 시, 항시 리턴 타입을 명시해야하며, 타입추론은 리턴할 함수가 블록바디가 아닌경우에만 사용하라.
 * */

val names = listOf("P", "PAT", "PAUL", "PAULA")

/*fun predicateOfLength(length: Int): (String) -> Boolean {
    return { input: String -> input.length == length}
}*/

// predicateOfLength 도 타입 추론을 통해 조금 더 개선.
fun predicateOfLength(length: Int) = { input: String -> input.length == length }

/**
 * 재사용을 위해서 람다를 변수에 넣을 수 있다.
 * 람다가 함수의 아규먼트로 전달될 때 파라미터의 타입추론이 일어난다. 그래서 타입에 대한 정보를 기술해야 컴파일러가 인식한다.
 *
 * */
val checkLengthFive = { name: String -> name.length == 5 }

// 변수의 타입을 지정하고 람다의 파라미터의 타입을 추론하도록 정의하는 것도 가능하다.
val checkLengthFiveAndSetType: (String) -> Boolean = { name -> name.length == 5 }

/**
 * 변수의 타입은 타입추론을 사용하고 리턴타입을 지정하는 방식을 사용하는 방식도 있다.
 * 특정 소수의 예외적 상황이 아니라면 사용할 이유가없다.(무엇인지 모르겠으나 비동기를 다룰때 체크한다.)
 *
 * 익명함수내 파라미터에는 디폴트 값을 지정할 수 없다.
 * */
val checkLengthFiveAndAnonymousFunction = fun(name: String): Boolean { return name.length == 5 }

fun main() {
    //println(names.find {name -> name.length == 5})
    //println(names.find {name -> name.length == 4})
    //println(names.find(predicateOfLength(5)))
    //println(names.find(predicateOfLength(4)))
    println(names.find(checkLengthFive))
    println(names.find(checkLengthFiveAndSetType))
    println(names.find(checkLengthFiveAndAnonymousFunction))
    // 혹은 직접 기술하는 방식도 있다.
    println(names.find(fun(name: String): Boolean { return name.length == 5 }))
}