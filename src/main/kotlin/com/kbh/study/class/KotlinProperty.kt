package com.kbh.study.`class`

// 클래스가 속성만 가진경우 다음과 같이 선언이 가능하다.
// var, val 키워드를 붙이면 클래스의 자체 속성으로 인식한다.
class OnlyProperty(var name: String, var birthYear: Int){
    fun introduce(){
        println("안녕하세요 ${this.name} 입니다. ${this.birthYear} 생이며 잘 부탁드립니다.")
    }
}

fun main() {
    val a = OnlyProperty("김보훈", 1988)
    val b = OnlyProperty("배창현", 1986)
    val c = OnlyProperty("황성인", 1888)

    println("안녕하세요 ${a.name} 입니다. ${a.birthYear} 생이며 잘 부탁드립니다.")
    println("안녕하세요 ${b.name} 입니다. ${b.birthYear} 생이며 잘 부탁드립니다.")
    println("안녕하세요 ${c.name} 입니다. ${c.birthYear} 생이며 잘 부탁드립니다.")

    a.introduce()
    b.introduce()
    c.introduce()
}