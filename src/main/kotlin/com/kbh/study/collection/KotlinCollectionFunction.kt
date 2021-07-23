package com.kbh.study.collection

fun main() {
    val nameList = mutableListOf("김보훈","김동훈","황경화","배창현","카산드라")

    // 컬렉션 함수로 컬렉션을 순환하여 값을 얻을때 다음과 같은 3가지 방식이 존재한다.
    println(nameList.filter { name -> name.startsWith("김") })
    println(nameList.filter { name:String -> name.startsWith("김") })
    // 처음에 it 이 컬렉션 함수내에서 제공하는 일종의 키워드인줄 알았으나 그렇지 않다. 잘못 소개된 글들도 많다.
    // 정확하게는 컬렉션 함수는 java iterator 를 통해서 작업을 진행하고 이 iterator에 파라미터 값으로 넘기는 매개변수의 명칭이 it일 뿐이다.
    println(nameList.filter { it.startsWith("김") })
    // 이 외에도 map, any, all, none 등 다양한 컬렉션 함수가 있다.
    println(nameList.filter { it.startsWith("김") }.map { it.substring(0) to 2 }.toMap())
    // 좀더 세련되게 바꿔보자
    println(nameList.filter(findLastNameForKim()).associate(addAge()))
}

private fun addAge(): (String) -> Pair<String, Int> = { it.substring(0) to 30 }
private fun findLastNameForKim(): (String) -> Boolean = { it.startsWith("김") }