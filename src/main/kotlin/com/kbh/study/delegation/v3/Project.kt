package com.kbh.study.delegation.v3

/**
 * 델리게이션을 빌트인 기능으로 제공하지 않는 자바 스타일의 코딩으로 풀어낸 코드이다.
 *
 * 이제 각종 타입의 Worker를 구현하는 코드를 구성할수 있으나 디자인 패턴적으로 좋지 못하다.
 * Worker의 메서드가 늘어날 수록 Manager에서도 동일한 호출코드가 생기므로 반복적인 요소를 증가시킨다.
 *
 * 확장을 하기위해 클래스를 클래스를 변경하는 것은 개방 폐쇠의 원칙을 어기는 것이다.
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

class Manager(val worker: Worker) {
    fun work() = worker.work()
    fun takeVacation() = worker.takeVacation()
}

fun main() {
    val doe = Manager(JavaProgrammer())
    doe.work()
}