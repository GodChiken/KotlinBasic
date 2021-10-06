package com.kbh.study.basic

class TypeConversion {
    //기본 자료형들은 type cast function을 toXXXX() 형식으로 제공한다.
    private var intValue : Int = 54321
    // 또한 명시적 형변환 (explicit type casting) 을 해야지만 할당이 가능하다.
    // 형변환시 오류를 막기위해 타 언어에서 제공하는 묵시적 형변환(Implicit type casting)을 제공하지 않는다.
    var toLongExampleForExplicitTypeCasting : Long = intValue.toLong()
    var toByteExampleForExplicitTypeCasting : Byte = intValue.toByte()

    fun fetchMessage(id : Int): Any = if (id == 1) "Record found" else StringBuilder("data not found")
}

fun main() {
    val typeConversion = TypeConversion()
    println(typeConversion.toLongExampleForExplicitTypeCasting)
    println(typeConversion.toByteExampleForExplicitTypeCasting)

    /**
     * as 키워드는 명시적으로 캐스트하는 연산자이나 안전하지 않다.
     * 단순하게만 사용한다면 형변환을 기대한 개발자의 의도와 다르게 작동한다. (exception)
     * null 허용 연산자 "?"와 함께 사용하여 비교적 캐스팅에서 발생될 수 있는 오류를 방지가 가능하다.
     * 해서 실무에서라면 되도록이면 smart casting을 수행하는 is 키워드를 활용하고 차선책으로 "as?" 와 같은 형태로 캐스트하자.
     */
    for (id in  1..2){
        //println("message length : ${(typeConversion.fetchMessage(id) as String).length}")
        println("message length : ${(typeConversion.fetchMessage(id) as? String)?.length ?: "---"}")
    }
}