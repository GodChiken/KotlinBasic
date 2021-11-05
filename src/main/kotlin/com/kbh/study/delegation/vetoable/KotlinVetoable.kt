package com.kbh.study.delegation.vetoable

import kotlin.properties.Delegates.vetoable

/**
 * 변경을 감지하여 특정 규칙으로 변화를 허용하고 싶을 때 사용한다.
 * */

fun main(){
    var count by vetoable(0) { _, oldValue, newValue -> newValue > oldValue }
    println("The value of count is : $count")
    count++
    println("The value of count is : $count")
    count--
    println("The value of count is : $count")
}