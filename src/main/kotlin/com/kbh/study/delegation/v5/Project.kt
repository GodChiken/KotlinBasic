package com.kbh.study.delegation.v5

/**
 * 기존 v4는 델리게이션을 적용하였으나 오직 JavaProgrammer만 받을 수 있다.
 * 또한 Manager의 인스턴스는 델리게이션에 접근할 수 없다. Manager 클래스 안에 다른 메서드를 작성할때 이 메서드는 델리게이션에 접근할 수 없다.
 * 이와 같은 문제점은 델리게이션을 선언시 지정하지 않고 델리게이션 파라미터를 활용하면서 해결이 가능하다.
 *
 * staff를 val 키워드를 통해 클래스의 속성으로 남는다. meeting 메서드는 staff에 접근할 수 있게된다.
 *
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

class Manager(val staff : Worker) : Worker by staff {
    fun meeting() = println("organizing meeting with ${staff.javaClass.simpleName}")
}

fun main(){
    val doe = Manager(CSharpProgrammer())
    val roe = Manager(JavaProgrammer())
    doe.work()
    doe.meeting()
    roe.work()
    roe.meeting()
}