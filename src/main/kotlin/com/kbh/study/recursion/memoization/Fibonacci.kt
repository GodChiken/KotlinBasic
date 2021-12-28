package com.kbh.study.recursion.memoization

import kotlin.system.measureTimeMillis

fun fib(n: Int) : Long = when (n) {
    0,1 -> 1L
    else -> fib(n - 1) + fib(n - 2)
}

fun main() {
    println(measureTimeMillis { fib(40) })
    println(measureTimeMillis { fib(45) })
}