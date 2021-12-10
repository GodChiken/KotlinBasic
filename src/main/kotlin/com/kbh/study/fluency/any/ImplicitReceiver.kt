package com.kbh.study.fluency.any

/**
 * printIt()은 람다를 참조한다.
 * 람다는 Int를 파라미터로 받아 아무것도 리턴하지 않는고 렉시컬 스코프에 의하여 외부의 length를 찾게된다.
 *
 * printItByString()는 람다에 리시버를 세팅하도록 시그니처가 변경되었다.
 * 람다가 String 인스턴스의 컨텍스트에서 실행되는 구조이다.
 *
 * printItByString("Hello",6)는 컨텍스트 혹은 리시버를 내부 this에 바운딩하는 방법중 하나이다.
 *
 * "Hello".printItByString(6)는 코틀린이 람다를 리시버의 확장함수처럼 취급한다.
 * */

var length = 100

//(Int) -> Unit
val printIt: (Int) -> Unit = { n: Int ->
    println("n is $n, lenth is $length")
}
//String.(Int) -> Unit
val printItByString: String.(Int) -> Unit = { n: Int ->
    println("n is $n, lenth is $length")
}
fun main() {
    printIt(6)
    printItByString("Hello",6)
    "Hello".printItByString(6)
}