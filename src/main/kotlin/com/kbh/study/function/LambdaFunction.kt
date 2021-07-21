package com.kbh.study.function

fun c(str: String) {
    println("$str 함수 c 입니다.")
}
// 다른 함수를 인자로 받거나 리턴하는 함수를 high order function 이라 불리운다.
fun d(function: (String) -> Unit) {
    function("d가 호출한")
}

fun main() {
    //high order function 형태로 넘기려면 :: 를 붙여 사용한다.
    d(::c)
    // 람다함수는 변수의 자료형을 선언하는 부분에 함수의 형식을 작성하고 = 이후에 구체적인 함수의 기능부를 구현한다.
    // 또한 람다함수는 그 자체가 고차함수이므로 ::를 생략하고 사용이 가능하다.
    // str은 원래 :String으로 자료형을 나타내 주어야하나 함수의 형식에서 이미 자료형이 결정 되어있으므로 자료형이 자동으로 추론되어 생략이 가능하다.
    val f : (String) -> Unit = { str -> println("$str 람다함수") }
    d(f)
    // 람다함수는 변수에 할당할 경우 이전에 배웠던 타입 추론을 통해서 좀더 축약된 형태로 기술이 가능하다.
    // 컬렉션, 스코프 함수를 사용하는데 유용하다고 알려져있다.
    val g = {str:String -> println("$str 다른형태의 람다함수")}
    g("기모찌")
}