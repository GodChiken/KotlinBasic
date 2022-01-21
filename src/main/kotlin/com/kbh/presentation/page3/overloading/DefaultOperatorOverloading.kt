package com.kbh.presentation.page3.overloading

/**
 * 남용하지 말고 직관적일때 사용한다.
 * 일반적인 연산자의 동작을 수행하고, 사용하는 변수의 이름을 의미있게하여 오버로딩의 문맥을 파악하게 해야한다.
 * */

fun main(){
    var x = 1
    var y = 2
    var z = arrayOf(1,2,3,4)
    var i = true
    var school = School("안양대")
    var numberList = mutableListOf(1,2,3,4,5)

    x.unaryPlus()            // +x
    x.unaryMinus()           // -x
    i.not()                  // !x
    x.plus(y)                // x + y
    x.minus(y)               // x - y
    x.times(y)               // x * y
    x.div(y)                 // x / y
    x.rem(y)                 // x % y
    x.inc()                  // ++x, x++
    x.dec()                  // --x, x--
    x.equals(y)              // x == y
    !(x.equals(y))           // x != y
    x.compareTo(y)           // <, >, <=, >=
    z.get(1)                 // z[i]
    z.set(0,y)               // z[0] = y
    z.contains(y)            // y in z
    x.rangeTo(y)             // x..y

    /**
     * '()' 함수호출 연산자를 오버로딩한 케이스
     * */
    println(school(4, "김보훈"))       // (a,b)
    println(school())                            // ()

    /**
     * 복합 연산자(+=, -+, /=, ...etc)를 오버로딩하는경우, 해당 연산자에 Assign을 추가하여 활용하면된다.
     * 그러나 예를 들어 plus(), plusAssign()을 동시에 구현하면 컴파일 오류가 발생한다.
     *
     * plus()는 순수함수이며 새로운 인스턴스를 리턴한다.
     * plugAssign()은 뮤터블인 피연산자의 상태를 변경시킨다.
     * */
    numberList.plusAssign(5)

    var counter = Counter(2)
    println(counter)
    println(++counter)
    println(counter)
    println(counter++)
    println(counter)
}
class School(val schoolName: String) {
    operator fun invoke(grade: Int, name: String){
        println(schoolName + " " + grade + "학년 " + name)
    }
    operator fun invoke(){
        println(schoolName)
    }
}

class Counter(val value: Int) {
    operator fun inc() = Counter(value + 1)
    operator fun dec() = Counter(value - 1)
    override fun toString() = "$value"
}