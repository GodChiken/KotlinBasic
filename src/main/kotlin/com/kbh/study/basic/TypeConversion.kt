package com.kbh.study.basic

class TypeConversion {
    //기본 자료형들은 type cast function을 toXXXX() 형식으로 제공한다.
    private var intValue : Int = 54321
    // 또한 명시적 형변환 (explicit type casting) 을 해야지만 할당이 가능하다.
    // 형변환시 오류를 막기위해 타 언어에서 제공하는 묵시적 형변환(Implicit type casting)을 제공하지 않는다.
    var toLongExampleForExplicitTypeCasting : Long = intValue.toLong()
    var toByteExampleForExplicitTypeCasting : Byte = intValue.toByte()
}

fun main() {
    val typeConversion = TypeConversion()
    println(typeConversion.toLongExampleForExplicitTypeCasting)
    println(typeConversion.toByteExampleForExplicitTypeCasting)
}