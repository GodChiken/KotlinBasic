package com.kbh.study.dsl

val langsAndAuthors =
    mapOf("Javascript" to "Eich", "Java" to "Gosling", "Ruby" to "Matz")

val xmlString = xml {
    root("language") {
        langsAndAuthors.forEach { name, author ->
            element("language", "name" to name) {
                element("author") { text(author) }
            }
        }
    }
}

fun xml(block: XMLBuilder.() -> Node): Node = XMLBuilder().run(block)

class XMLBuilder {
    fun root(rootElementName: String, block: Node.() -> Unit): Node =
        Node(rootElementName).apply(block)
}

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
        children + child
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