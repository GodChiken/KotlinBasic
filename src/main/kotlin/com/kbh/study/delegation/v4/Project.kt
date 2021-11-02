package com.kbh.study.delegation.v4

/**
 * 직접구현하는 것 보다 'by' 키워드를 통해 빌트인 델리게이션을 활용하여 비교적 간단하게 델리게이션을 구현했다.
 * */

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

class Manager() : Worker by JavaProgrammer()

fun main(){
    val doe = Manager()
    doe.work()
    // val coder : JavaProgrammer = doe //type mismatch
}