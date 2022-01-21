package com.kbh.presentation.page3.dsl.xml.scope

/**
 * 호스트언어(스코프의 속성접근이나 임의의 함수와 메소드 호출 등)에서 할수있는 일은 내부 DSL코드에서도 할 수있다.
 * 접근 권한자체가 너무 자유롭게 때문에 제한이 필요할 때가 존재한다. 컴파일러에게 탑레벨 함수나 렉시컬 스코프에 접근권한을
 * 거부하도록 만들수있는 방법은 @DSLMaker 어노테이션을 사용하는 방법이다.
 *
 * 이를 사용함으로써 람다의 부모 리시버의 멤버에 암시적 접근을 거부하게 할 수 있다.
 * "리시버를 이용한 멀티플 스코프(MultipleReceiver.kt)" 에서
 * 중첩 람다가 두개의 리시버를 가지는 방식에 대해서 학습했는데,
 * DSL을 만들 때 람다가 현재 실행 중인 암시적 리시버에만 접근이 가능하도록 하고
 * 부모 리시버의 멤버에 접근하는 것을 제한하게 할 수 있다.
 *
 * 가령 이전 XMLBuilder.kt에서 작성했던 코드는 xmlString 에서 또다른 root가 파생될 위험이 있다.
 * 컴파일러에서 이와같은 상황에 대해 에러가 없는 이유는 다음과 같이 이해하면 된다.
 * element 중 2번째 호출은 암시적 리시버 this로 Node 인스턴스에서 호출되듯,
 * 2번째 root 호출은 부모 리시버에 의해서 발생되기 때문이다.
 * 즉 1,2번째 root 호출 모두가 같은 인스턴스로 라우팅된다.
 *
 * 이런 경우를 방지하기위해 DSL 빌딩에 참여되는 모든 클래스와 베이스 클래스 모두에 커스텀 DSL 마커 어노테이션을 추가한다.
 *
 * XMLMarker와 같은 마커 어노테이션을 생성한다.
 * - DSL 마커가 적용된 클래스는 컴파일러에게 객체 참조가 없는 호출("someobj." 와같은 접두사가 없는)을 실행중인 리시버에서만 가능하도록 한다.
 * - 부모 리시버는 사용이 불가하다.
 * - 이렇게 구성되면 암시적 리시버를 사용이 불가하므로 현재 사용되는 리시버에서 처리가 불가할 경우 컴파일 에러가 난다.
 * - DSL 내 스코프의 컨트롤을 요할 경우 사용하자.
 *
 * */


@DslMarker
annotation class XMLMarker


val langsAndAuthors =
    mapOf("Javascript" to "Eich", "Java" to "Gosling", "Ruby" to "Matz")

val xmlString = xml {
    root("languages") {
        langsAndAuthors.forEach { name, author ->
            element("language", "name" to name) {
                element("author") { text(author) }
                //root("시작점이 이곳에서 만들어지면 안되는데??") {}
                //root("@XMLMarker 때문에 암시적 리시버를 호출 불가하다.") {}
                //this@xml.root("그래도 구지 원한다면 명시적으로..?") {}
            }
        }
    }
}

fun xml(block: XMLBuilder.() -> Node): Node = XMLBuilder().run(block)

@XMLMarker
class XMLBuilder {
    fun root(rootElementName: String, block: Node.() -> Unit): Node =
        Node(rootElementName).apply(block)
}

@XMLMarker
class Node(val name: String) {
    var attributes: Map<String, String> = mutableMapOf()
    var children: List<Node> = listOf()
    var textValue: String = ""

    fun text(value: String) {
        textValue = value
    }

    fun element(
        childName: String,
        vararg attributeValues: Pair<String, String>,
        block: Node.() -> Unit
    ): Node {
        val child = Node(childName)
        attributeValues.forEach { child.attributes += it }
        children += child
        return child.apply(block)
    }

    fun toString(indentation: Int): String {
        val attributeValues = if (attributes.isEmpty()) "" else
            attributes.map { "${it.key} = '${it.value}'" }.joinToString(" ", " ")
        val DEPTH = 2
        val indent = " ".repeat(indentation)
        return if (!textValue.isEmpty()) {
            "$indent<$name$attributeValues>$textValue</$name>"
        } else {
            """$indent<$name$attributeValues>
                |${children.joinToString("\n") { it.toString(indentation + DEPTH) }}
                |$indent</$name>""".trimMargin()
        }
    }

    override fun toString() = toString(0)
}

fun main() {
    println(xmlString)
}