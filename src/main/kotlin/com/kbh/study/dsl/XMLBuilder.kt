package com.kbh.study.dsl

/**
 * 언어와 저자로 이루어진 데이터를 XML을 만든다.
 * */
val langsAndAuthors =
    mapOf("Javascript" to "Eich", "Java" to "Gosling", "Ruby" to "Matz")

/**
 * 루트를 기반으로 하여 0개 이상의 정적속성과 자식 요소를 포함하는 XML의 특성을 바탕으로 작성된 XML DSL
 * */
val xmlString = xml {
    root("languages") {
        langsAndAuthors.forEach { name, author ->
            element("language", "name" to name) {
                element("author") { text(author) }
            }
        }
    }
}
/**
 * 람다를 파라미터로 받는 함수로 설계하고 빌드를 대신한 XMLBuilder 객체를 리턴하도록 구성한다.
 * 일종의 부트스트랩? 함수이며, XMLBuilder타입의 리시버를 가지는 block(람다)이다.
 * XMLBuilder의 컨텍스트에서 어떤 메소드나 함수의 호출도 작동되도록 구성했다.
 * 코드블록을 리시버의 컨텍스트에서 실행시키고 블록의 결과를 리턴하기위해 확장함수 run()이 사용된다.
 * */
fun xml(block: XMLBuilder.() -> Node): Node = XMLBuilder().run(block)

/**
 * xml() 함수에 람다를 전달할 첫 줄의 코드는 root() 함수를 호출했다.
 * ..
 * */
class XMLBuilder {
    fun root(rootElementName: String, block: Node.() -> Unit): Node =
        Node(rootElementName).apply(block)
}

class Node(val name: String) {
    var attributes: Map<String, String> = mutableMapOf()
    var children: List<Node> = listOf()
    var textValue: String = ""

    fun text(value: String) { textValue = value }

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