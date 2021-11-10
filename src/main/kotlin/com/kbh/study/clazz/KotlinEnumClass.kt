package com.kbh.study.clazz

fun main() {
    val a = State.SLEEP
    val b = State.WAKE_UP
    println(a.isSleeping())
    println(a.isWakeUp())
    println(b.isSleeping())
    println(b.isSleeping())
}
enum class State(val message:String){
    SLEEP("잠자다"),
    WAKE_UP("일어나다");

    fun isSleeping() = this == SLEEP
    fun isWakeUp() = this == WAKE_UP
}