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

    /**
     * sequence
     *
     * 컬렉션의 성능향상을 위한 최적화 랩퍼를 의미한다.
     * 자바와 다르게 Stream<t>를 활용하지 않아도 컬렉션에서 바로 사용이 가능하다.
     * 자바에서 성능상의 이유때문에 컬렉션에서 직접 사용하지 못하도로고 디자인이 되어있다.
     *
     * 콜렉션 사이즈 작을때 내부 반복자를 사용해야하며, 사이즈가 큰 경우에 시퀀스를 사용하여 내부 반복자를 사용해야한다.
     * 위의 예시에서 작을경우 시퀀스를 사용하지 않기떄문에 콜렉션의 연산이 계속해서 일어나는 반면 크기가 크고 시퀀스를 사용하는경우 지연 실행이 가능하다.
     *
     * 지연실행을 하는 이유는 불필요한 경우 실행을 연기하여 시간과 자원을 절약하기 위함이다.
     *
     * 시퀀스를 활용하여 연산하는경우 최종연산 전까지는 항상 또다른 시퀀스가 다음 연산으로 전달된후 최종연산시 파이프라인의 실행 결과를 리턴한다.
    * */
    val result11 = peopleList
        .filter (::isAdult)
        .map (::fetchFirstName)
        .first()

    val result12 = peopleList.asSequence()
        .filter (::isAdult)
        .map (::fetchFirstName)
        .first()

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

    println(result11)
    println(result12)

}

fun isAdult(person: Person): Boolean {
    println("isAdult called for ${person.firstName}")
    return person.age > 17
}

fun fetchFirstName(person: Person): String {
    println("fetchFirstName called for ${person.firstName}")
    return person.firstName
}