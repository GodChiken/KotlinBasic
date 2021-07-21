package com.kbh.study.`class`

class KotlinConstructor(var name: String, var birthYear: Int) {
    // 코틀린의 기본 생성자이며 파라미터 및 반환형이 없다.
    init {
        println("안녕하세요 ${this.name} 입니다. ${this.birthYear} 생이며 잘 부탁드립니다.")
    }
    // 보조 생성자 생성시 반드시 기본 생성자를 통해 속성을 초기회 해야하며, ': this' 를 기술한다.
    constructor(name: String) : this(name, 1988){
        println("보조 생성자사 생성됨")
    }
}

fun main() {
    KotlinConstructor("김보훈",1888)
    KotlinConstructor("김보훈")
    KotlinConstructor("배창현")
    KotlinConstructor("황성인")
}