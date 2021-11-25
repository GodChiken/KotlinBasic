package com.kbh.study.fluency

import kotlin.math.abs

/**
 * operator를 제거하면 '*' 부분에서 에러가 발생한다.
 * 특별히 명명된 메서드가 아닌곳에 operator를 사용하면 에러가발생한다.
 * */

data class Complex(val real: Int, val imaginary:Int) {
    operator fun times(other: Complex) =
        Complex(real * other.real - imaginary * other.imaginary, real * other.imaginary + imaginary * other.real)
    private fun sign() = if (imaginary < 0) "-" else "+"
    override fun toString() = "$real ${sign()} ${abs(imaginary)}i"
}

fun main() {
    println(Complex(4,2) * Complex(-3, 4))
    println(Complex(1,2) * Complex(-3, 4))
}