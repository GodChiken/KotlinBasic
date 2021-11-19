package com.kbh.study.function.internal

data class Person(val firstName : String, val age: Int)
val peopleList = listOf(
    Person("Sara", 12),
    Person("Jill", 51),
    Person("Paula", 23),
    Person("Paul", 25),
    Person("Mani", 12),
    Person("Jack", 70),
    Person("Sue", 10),
)

fun main() {
    val result = peopleList.filter { person -> person.age > 20 }
        .map { person -> person.firstName }
        .map { name -> name.uppercase() }
        .reduce { names, name -> "$names, $name"}

    val result2 = peopleList.filter { person -> person.age > 20 }
        .map { person -> person.firstName }
        .map { name -> name.uppercase() }
        .joinToString(", ")

    val result3 = peopleList.map { person -> person.age }
        .sum();

    println(result);
    println(result2);
    println(result3);
}