package com.kbh.study.api

import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

fun main(){
    println(1.days)
    println(1.days.inWholeHours)
    println(1.days.inWholeMilliseconds)
    println(1.days - 2.hours)
    println(1.days - 2.hours - 3.minutes)

    val oneDay = 1.days
    val twoHours = 2.hours
    val threeMinute = 3.minutes
    val result = oneDay - twoHours - threeMinute
    println(result.toIsoString())
    println(result.absoluteValue)
}