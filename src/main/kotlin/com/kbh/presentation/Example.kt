package com.kbh.presentation

data class Employee(
    val name: String,
    val email: String,
    val company: String
) // + automatically generated equals(), hashCode(), toString(), and copy()

object MyCompany {                                // A singleton
    const val name: String = "Ictus"
}

fun main() {                                      // Function at the top level
    val employee = Employee("김보훈",               // No `new` keyword
        "godchiken@ictus.app", MyCompany.name)
    println(employee)
}