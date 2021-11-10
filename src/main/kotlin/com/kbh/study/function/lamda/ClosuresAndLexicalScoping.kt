package com.kbh.study.function.lamda

/**
 * 함수형 프로그래밍에서 람다와 클로저 두가지의 개념을 교환해서 사용하나 문맥상 어떤 것이 더 적합하고 차이점이 무엇인지 정확하게
 * 알아야한다.
 *
 * 람다는 상태가 없다. 람다의 결과는 입력 파라미터의 값에 달려있다.
 * 람다는 스코프를 로컬이 아닌 속성과 메서드로 확장할 수 있다.
 *
 * doubleIt의 람다는 현재 클로저(외부 상태에 의존)로 만들어졌다. 람다 안에서 factor는 로컬변수가 아니므로 이에대해서 외부 상태를 찾기위해
 * 스코프를 확장하는 행위를 렉시컬 스코핑(Lexical Scoping)라 정의된다.
 *
 * 함수형 프로그래밍에서 뮤터블은 금지해야한다. 클로저 내에서 뮤터블에 대해서 변경이 가능해지면 코틀린 컴파일러가 따로 경고를 하지 않기때문이고
 * 코드를 읽는데 있어 혼란스러워지기 때문이다.
 *
 * main() 내에서 코드의 결과를 예측하긴 어렵다.
 * sequenceOf()는 지연 연산으로 처리되기 때문에 실제로 사용되었을때 최종적인 연산이 일어나므로 factor의 변경사항이 적용된다.
 * */

val factor = 2
val doubleIt = { e: Int -> e * factor }

fun main() {
    var factor2 = 2
    val doubled = listOf(1,2).asSequence().map { it * factor2}
    val doubledAlso = sequenceOf(1,2).map { it * factor2}
    factor2 = 0
    doubled.forEach{ println(it) }
    doubledAlso.forEach{ println(it) }
}
