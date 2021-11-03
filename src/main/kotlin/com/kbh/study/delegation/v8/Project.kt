package com.kbh.study.delegation.v8

/**
 * 델리게이션을 통해 우리는 Manager가 JavaProgrammer를 사용할 수 있게하되, JavaProgrammer의 파생되는 클래스가 되지 않도록 하였다.
 * 즉 우연히 대체될 가능성이 없게하고 재사용성을 제공해준다.
 *
 * 하지만 코틀린에서 델리게이션을 해야하는경우, 위임할 인터페이스를 구현해며 val 키워드를 써야한다.
 * 그렇지 않은경우 우리는 델리게이션이 무엇을 하는지 놓치기 쉽다.
 *
 * Manager의 staff를 변경하였으나 의도와 다르게 변경되어 출력되지 않았다.
 * 주어진 객체에는 2가지의 참조가 있다. 클래스 내부의 백킹 필드, 델리게이션을 목적으로 존재하는 참조다.
 *
 * 즉, 인스턴스의 필드만 변경했을뿐 델리게이션의 참조를 변경한 것이 아니다.
 * 코틀린은 객체의 속성이 아닌 주 생성자에서 보내진 파라미터로 델리게이션을 하며 추후 변동의 여지가 있다.
 *
 * var 키워드를 사용해게되면 변경 전 인스턴스에 접근도 불가하고, 객체와 델리게이션의 생명주기가 동일해진다.
 * */

interface Worker {
    fun work()
    fun takeVacation()
    fun fileTimeSheet() = println("Why? Really?")
}

class JavaProgrammer : Worker {
    override fun work() {
        println("write java")
    }

    override fun takeVacation() {
        println("code at the beach")
    }

}

class CSharpProgrammer : Worker {
    override fun work() {
        println("write C#")
    }

    override fun takeVacation() {
        println("branch at the ranch")
    }
}

class Manager(var staff: Worker) : Worker by staff

fun main() {
    val roe = Manager(JavaProgrammer())
    // val coder : JavaProgrammer = roe
    val employee : Worker = roe

    println("staff is ${roe.staff.javaClass.simpleName}")
    roe.work()
    println("change staff CSharpProgrammer")
    roe.staff = CSharpProgrammer()
    println("staff is ${roe.staff.javaClass.simpleName}")
    roe.work()
}