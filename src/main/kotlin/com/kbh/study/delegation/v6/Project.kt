package com.kbh.study.delegation.v6

/**
 * 메서드 충돌관리에 대해서 생각해봐야한다. 코틀린 컴파일러는 델리게이션에 사용되는 클래스마다 델리게이션 메서드를 위한 래퍼를 만든다.
 * 사용하는 클래스와 델리게이션 클래스에 동일한 이름과 시그니처가 있는 메서드가 있다면 어떻게 충돌을 해결해야하는가 고민해봐야한다.
 * 코틀린은 이런 충돌을 해결하기 위해 선택을 할수 있고 델리게이션 클래스의 모든 메서드에 일일히 위임할 필요가 없도록 하였다.
 *
 * 이를 보기전에 예제 소스의 변경사항을 보면, 기존 개발자들이 자체적으로 휴가를 가지는 구조(Worker에게 휴가에 관련됨을 위임)이나
 * 변경 이후에는 매니저의 승인하에 관리가 되어야 한다.
 *
 * */

interface Worker {
    fun work()
    fun takeVacation()
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


class Manager(val staff: Worker) : Worker by staff {
    override fun takeVacation() = println("of course")
}

fun main() {
    val roe = Manager(JavaProgrammer())
    roe.work()
    roe.takeVacation()
}