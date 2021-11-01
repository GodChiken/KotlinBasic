package com.kbh.study.delegation.v1

interface Worker {
    fun work()
    fun takeVacation()
}

class JavaProgrammer : Worker{
    override fun work() {
        println("write java")
    }

    override fun takeVacation() {
        println("code at the beach")
    }

}
class CSharpProgrammer : Worker{
    override fun work() {
        println("write C#")
    }

    override fun takeVacation() {
        println("branch at the ranch")
    }
}

class Manager