package com.kbh.study.delegation.observable

import kotlin.properties.Delegates

/**
 * Delegates 내에 obeservable()는 연관 변수,속성의 변화를 감지하여 ReadWriteProperty 델리게이션을 만들어 이벤트 핸들러가 호출 되도록한다.
 * 이벤트 핸들러는 속성, 이전값, 새로운 값에 대한 메타데이터를 가지고있는 KProperty 타입의 파라미터를 가지며 아무것도 리턴하지 않는다.
 * */

fun main(){
    var count by Delegates.observable(0) { property, oldValue, newValue ->
        println("$property, $oldValue, $newValue")
    }
    println("The value of count is : $count")
    count++
    println("The value of count is : $count")
    count--
}