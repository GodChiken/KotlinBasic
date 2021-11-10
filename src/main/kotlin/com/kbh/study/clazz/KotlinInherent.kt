package com.kbh.study.clazz

fun main() {
    val a = Animal("김보훈", 34, "dog")
    val b = Dog("김보훈", 34)
    a.introduce()
    b.introduce()
    b.bark()
    val c = Cat("황경화",36)
    c.meow()
}

// 클래스는 'open' 상태가 아닌경우 상속이 불가능하다.
open class Animal(val name: String, val age: Int, val type:String) {
    fun introduce() {
        println("저는 $name 나이는 $age 형태는 $type")
    }
}

class Dog(name: String, age: Int) : Animal(name, age, "dog") {
    fun bark(){
        println("멍멍")
    }
}

class Cat(name: String, age: Int) : Animal(name, age, "cat") {
    fun meow(){
        println("야옹")
    }
}