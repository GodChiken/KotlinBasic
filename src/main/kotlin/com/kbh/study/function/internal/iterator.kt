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
val familyList = listOf(
    listOf(Person("Jack",40), Person("Jill", 40)),
    listOf(Person("Eve",18), Person("Adam", 18))
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
        .sum()

    /**
     * flat
     *
     * 람다가 단일로 매개변수를 받고 단일 리턴을 한다면 함수라면 map() 활용을 권장.
     * 람다가 단일로 매개변수를 받고 컬렉션을 리턴한다면 map() 활용
     * 람다가 단일로 매개변수를 받고 컬렉션을 리턴하지만 바로 변경해서 넣고싶은 경우 map() 활용
     * */

    val result4 = peopleList.map { person -> person.firstName }
        .map (String::lowercase)
        .map {name -> listOf(name, name.reversed())}

    val result5 = peopleList.map { person -> person.firstName }
        .map (String::lowercase)
        .map {name -> listOf(name, name.reversed())}
        .flatten()

    val result6 = peopleList.map { person -> person.firstName }
        .map (String::lowercase)
        .flatMap {name -> listOf(name, name.reversed())}


    /**
     * sort
     * */

    val result7 = peopleList.filter { person -> person.age > 17 }
        .sortedBy { person -> person.age }
        .map { person -> person.firstName }

    val result8 = peopleList.filter { person -> person.age > 17 }
        .sortedByDescending { person -> person.age }
        .map { person -> person.firstName }

    /**
     * grouping
     * */

    val result9 = peopleList.groupBy { person -> person.firstName.first() }

    val result10 = peopleList.groupBy({ person -> person.firstName.first() }) {
        person -> person.firstName
    }

    println(result)
    println(result2)
    println(result3)

    println(familyList.size)
    println(familyList.flatten().size)
    println(result4)
    println(result5)
    println(result6)

    println(result7)
    println(result8)

    println(result9)
    println(result10)

}