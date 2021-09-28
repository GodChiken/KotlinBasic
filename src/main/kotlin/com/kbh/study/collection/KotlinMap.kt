package com.kbh.study.collection

fun main() {
    // key - value를 to keyword 를 통해 할당이 가능하다.
    val map = mutableMapOf("김보훈" to 34, "경화" to 37)

    // key - value 요소에 접근은 다음과 같다.
    for (entry in map) {
        println("${entry.key} and ${entry.value}")
    }

    println(map.containsKey("김보훈"))
    println(map.containsKey("황경화"))
    println(map.containsValue(34))
    println("김보훈" in map)

    /**
     * map.get()의 이러한 error가 발생하는 이유는 nullable을 리턴한다.
     * val age : Int = map.get("김보훈") // error
     * val age : Int? = map.get("김보훈") // nullable 참조타입으로 변경
     * val age : Int? = map["김보훈"] // 인덱스 연산자로 접근
     *
     * 그러나 다음과 같은 방법으로 해당키가 존재하지 않으면 nullable 참조타입이 아니더라도 안전하게 값을 얻을 수 있다.
     * */
    val age: Int = map.getOrDefault("김보훈", 0)

    /**
     * map도 또한 list와 마찬가지로 "+","-" 를 통해 새로운 맵을 만들 수 있다.
     */
    val mapWithFriend = map + ("김형석" to 33)
    println(mapWithFriend)
    val mapWithOutFriend = map - ("김형석" to 33)
    println(mapWithOutFriend)

}