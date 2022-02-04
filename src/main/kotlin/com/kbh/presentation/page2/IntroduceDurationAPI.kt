package com.kbh.presentation.page2

import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

fun main(){
    val day = 1.days
    val hours = 3.hours
    val minutes = 4.minutes

    val result = day - hours - minutes
    val result2 = 1.days - 3.hours - 5.minutes

    println(result)
    println(result2)
}