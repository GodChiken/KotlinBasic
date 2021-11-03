package com.kbh.study.delegation.variable

import kotlin.reflect.KProperty

/**
 * 코틀린의 내부에서 프로퍼티와 지역변수를 읽고 쓸때 getValue(), setValue() 를 호출한다.
 * 객체의 델리게이션을 두 메서드와 함께 제공해주므로 변수를 델리게이션할 수 있다.
 * */

class PoliteString (var content : String){
    operator fun getValue(thisRef : Any?, property: KProperty<*>) =
        content.replace("stupid","s*****")
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        content = value
    }
}
// 클래스의 생성자말고 델리게이션 인스턴스를 리턴해주는 함수를 사용하고자 한다면 다음과 같이 작성한다.
fun beingPolite(content: String) = PoliteString(content)

fun main() {
    var comment: String by PoliteString("Some nice message")
    println(comment)
    comment = "This is Stupid"
    println(comment)
    println("comment is of length : ${comment.length}")

    var comment2 : String by beingPolite("Some nice message")
}