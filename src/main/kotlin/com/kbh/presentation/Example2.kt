package com.kbh.presentation

fun reply(condition: Boolean): String? =          // Nullability is part of Kotlin’s type system
    if (condition) "I'm fine" else null

fun error(): Nothing =                            // Always throw an exception
    throw IllegalStateException("Shouldn't be here")

fun main() {
    val condition = false                        // Try replacing `true` with `false` and run the sample!
    val message = reply(condition)              // The result is nullable
    //println(message.uppercase())             // This line doesn't compile
    println(message?.replace("fine", "okay"))   // Access a nullable value in a safe manner
    if (message != null) {                      // If you check that the type is right,
        println(message.uppercase())                // the compiler will smart-cast it for you
    }

    val nonNull: String =                             // If the null-case throws an error,
        reply(condition = true) ?: error()             // Kotlin can infer that the result is non-null
    println(nonNull)
}