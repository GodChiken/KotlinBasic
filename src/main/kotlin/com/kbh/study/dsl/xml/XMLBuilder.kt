package com.kbh.study.dsl.xml

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
 * 일종의 부트스트랩 함수이며, XMLBuilder타입의 리시버를 가지는 block(람다)이다.
 * XMLBuilder의 컨텍스트에서 어떤 메소드나 함수의 호출도 작동되도록 구성했다.
 * 코드블록을 리시버의 컨텍스트에서 실행시키고 블록의 결과를 리턴하기위해 확장함수 run()이 사용된다.
 * */
fun xml(block: XMLBuilder.() -> Node): Node = XMLBuilder().run(block)

/**
 * xml() 함수에 람다를 전달할 첫 줄의 코드는 root() 함수를 호출한다.
 * 이것은 XMLBuilder의 인스턴스의 컨텍스트에서 실행되기 때문이다.
 *
 * root() 메서드는 xml의 root 요소의 이름(language)을 받기 위한 rootElementName과
 * 리시버로 사용될 Node 인스턴스 컨텍스트에서 실행되는 block을 받는다.
 *
 * 람다는 Unit으로 선언되었으므로 아무것도 리턴하지 않는다.
 *
 * root() 메소드는 Node의 인스턴스를 생성하고 rootElementName을 아규먼트로 생성자에 전달한다.
 * 이후 block(람다)를 생성된 Node 인스턴스의 컨텍스트에서 실행시킨다.
 *
 * run()대신 apply()를 활용하여 람다가 Node 인스턴스의 컨텍스트에서 실행되게하고 리턴하기 위함이다.
 * */
class XMLBuilder {
    fun root(rootElementName: String, block: Node.() -> Unit): Node =
        Node(rootElementName).apply(block)
}

/**
 * root()에 전달된 블록에서 langsAndAuthors의 맵 요소를 반복하고 각 이름과 저자를 중첩 요소(element)로 두게된다.
 * 그리고 root()함수 내에서 생성된 노드에서 존재해야 xml의 규칙이 성립된다. 즉 블록의 리시버이다.
 *
 * 이런 구조를 성립하기 위해서 element 메서드를 Node 내부에 만들고 자식 Node를 만들어 현재의 Node에 추가하도록 구성해야한다.
 *
 * 각 Node 인스턴스는 정적 속성 콜렉션, 자식노드 컬렉션, 텍스트값을 유지해야한다.
 * */
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

/**
 * xml(), element()내에서 사용된 리시버와 함께 사용되는 람다의 기능 덕에 Node 인스턴스의 컨텍스트에서 람다를 실행할 수 있게됬다.
 * 결론적으로 DSL에서 this 없이 Node의 메소드를 호출할 수 있게 됬다.
 * */
fun main() {
    println(xmlString)
}