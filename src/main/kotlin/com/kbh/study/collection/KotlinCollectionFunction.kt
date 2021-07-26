package com.kbh.study.collection

fun main() {
    val nameList = mutableListOf("김보훈", "김동훈", "황경화", "배창현", "카산드라")

    // 컬렉션 함수로 컬렉션을 순환하여 값을 얻을때 다음과 같은 3가지 방식이 존재한다.
    println(nameList.filter { name -> name.startsWith("김") })
    println(nameList.filter { name: String -> name.startsWith("김") })
    // 처음에 it 이 컬렉션 함수내에서 제공하는 일종의 키워드인줄 알았으나 그렇지 않다. 잘못 소개된 글들도 많다.
    // 정확하게는 컬렉션 함수는 java iterator 를 통해서 작업을 진행하고 이 iterator에 파라미터 값으로 넘기는 매개변수의 명칭이 it일 뿐이다.
    println(nameList.filter { it.startsWith("김") })
    // 이 외에도 map, any, all, none 등 다양한 컬렉션 함수가 있다.
    println(nameList.filter { it.startsWith("김") }.map { it.substring(0) to 2 }.toMap())
    // 좀더 세련되게 바꿔보자
    println(nameList.filter(findLastNameForKim()).associate(addAge()))


    val personList = listOf(
        Person("김보훈", 1992),
        Person("김동훈", 1996),
        Person("황경화", 1999),
        Person("배창현", 2003)
    )
    // associateBy : 아이템에서 key 추출 이후 map 형태로 반환
    println(personList.associateBy { it.birthYear })
    // groupBy : 특정 값을 기준으로 하여 grouping 하는 함수
    println(personList.groupBy { it.birthYear })
    /**
    partition : 특정 조건으로 분리하는 함. Pair 로 반환되며 각각의 요서는 first, second 로 접근이 된다.
    혹은 Destructuring Declarations 을 활용하여 받고자하는 변수명을 기술하여도 좋다.
    오른쪽이 참 결과 기준이다.
     */
    val (over2000, under2000) = personList.partition { it.birthYear > 2000 }
    println(over2000)
    println(under2000)

    // flatMap : 각 요소의 여러 결과를 단일 리스트로 만드는데 사용된다.
    // toList : 분할이 가능한 해당 요소를 구성하는 모든 요소들을 리스트화 해서 반환한다
    val numberList = listOf("123", "45")
    println(numberList.flatMap {
        it.toList()
    })
    // getOrElse : (index) 에 해당하는 값이 존재하는경 해당 객체를 반환하며 그렇지 않은경우 {} 내의 결과를 반환한다.
    val numberList2 = listOf(-3, 7, 2, -10, 1)
    println(numberList2.flatMap { listOf(it * 10, it + 10) })
    println(numberList2.getOrElse(1) { 50 })
    println(numberList2.getOrElse(10) { 50 })

    // zip : 두 컬렉을 1:1 매핑해서 Pair 객체로 감싼 후, List 형태로 반환한다. 둘중 구성요소의 갯수가 더 작은 쪽을 기준으로 하여 결과가 나온다.
    val charList = listOf('A', 'B', 'C')
    println(charList zip numberList2)

}

data class Person(val name: String, val birthYear: Int)

private fun addAge(): (String) -> Pair<String, Int> = { it.substring(0) to 30 }
private fun findLastNameForKim(): (String) -> Boolean = { it.startsWith("김") }