package com.kbh.study.delegation.v2

/**
 * Manager는 Work를 구현하는 클래스를 더이상 베이스 클래스로 선택할 수 없다.
 * Manager는 특정 프로그래머라고 지칭될 수 없으나 상속을 쓰면 설계적인 면에서 갇혀버리게 된다.
 *
 * 구현의도는 Worker에게 Manager가 의존하게 하는 것이므로 델리게이션을 다음 버전에서 확인한다.
 * */

interface Worker {
    fun work()
    fun takeVacation()
}

open class JavaProgrammer : Worker{
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

class Manager : JavaProgrammer()

fun main(){
    val doe = Manager()
    doe.work()
    val coder : JavaProgrammer = doe
}