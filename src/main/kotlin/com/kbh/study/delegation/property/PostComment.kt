package com.kbh.study.delegation.property

import kotlin.reflect.KProperty

/**
 * 기존 변수 프로퍼티에서 사용된 PoliteString을 변경하여 내부에 저장하지 않고 기존 데이터에 저장하는 구조로 변경했다.
 * */

class PoliteString(val dataSource: MutableMap<String, Any>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        (dataSource[property.name] as? String)?.replace("stupid", "s*****") ?: ""

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        dataSource[property.name] = value
    }
}

/**
 * dataSource에 get/set을 위임한다.
 * dataSource는 파라미터로 들어왔으며 프로퍼티의 get/set을 위임하는 델리게이션이다.
 * 프로퍼티명과 데이터의키값은 동일해야 작동되도록 설계되어있다.
 *
 * 모든 속성을 위임할 필요없다. 다른 델리게이션에 위임하거나 단순히 필드를 저장하고 있어도 된다.
 * 직접 델리게이션을 만들어보는 것을 끝냈다.
 * */
class PostComment(dataSource: MutableMap<String, Any>) {
    val title: String by dataSource
    var likes: Int by dataSource
    val comment: String by PoliteString(dataSource)
    override fun toString(): String = "$title ::: $likes ::: $comment"
}

/**
 * 예제에서는 listOf에 직접 mutableOf 를 넣어 코드를 수행하나 다음 기준에서 되지 않는다.
 * - 2021년 11월 기준
 * - plugin version = 212 1.5.10.release
 *
 * 값으로는 동일하나 Map을 List에 담아서 사용하는경우 Value 부분에 out 키워드가 활용된 공변성이 추가된다.
 * */
fun main() {
    val data = listOf(
        mutableMapOf(
            "title" to "UsingDelegation",
            "likes" to 2,
            "comment" to "Keep it simple, stupid"
        ),
        mutableMapOf(
            "title" to "UsingInheritance",
            "likes" to 1,
            "comment" to "Prefer Delegation where possible"
        )
    )

    val forPost1 = PostComment(
        mutableMapOf(
            "title" to "UsingDelegation",
            "likes" to 2,
            "comment" to "Keep it simple, stupid"
        )
    )
    val forPost2 = PostComment(
        mutableMapOf(
            "title" to "UsingInheritance",
            "likes" to 1,
            "comment" to "Prefer Delegation where possible"
        )
    )
    forPost1.likes++
    println(forPost1)
    println(forPost2)
}