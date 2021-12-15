package com.kbh.study.dsl

import java.util.*
import com.kbh.study.dsl.DateUtil.Tense.*

/**
 *
 * person run "fast"
 *
 * 와 같은 코드를 만드려면 점과 괄호를 제거하려 infix를 사용하려니 person 객체의 참조가 필요하다.
 * 구지 위와같은 형태가 아니더라도 객체의 참조를 제거하고 run("fast") 같은 코드도 작성할 수 있다.
 * [괄호와 점], [객체 참조]를 둘다 제거하고 하자니 실상 불가하다.
 *
 * 한가지 해법으로 람다 내부에 person 대신 this를 활용하면 암시적 참조가 명시적 참조가 될수있다.
 * 그러나 this run "fast"는 자연스럽지 못하다.
 *
 * 확장 함수를 통해 조금 더 자연스러운 문법을 만들 수 있는 솔루션을 생각해본다.
 *
 * 특정 이벤트가 2일 전에 일어났다는 기능과 3일후에 특정 이벤트 알림 기능을 가진 프로그램을 개발한다 가정한다.
 *
 * */


infix fun Int.days(timing: DateUtil.Tense) = DateUtil(this, timing)

class DateUtil (val number:Int, val tense: Tense){
    enum class Tense {
        AGO, FROM_NOW
    }

    override fun toString(): String {
        val today = Calendar.getInstance()
        when (tense) {
            AGO -> today.add(Calendar.DAY_OF_MONTH, -number)
            FROM_NOW -> today.add(Calendar.DAY_OF_MONTH, number)
        }
        return  today.time.toString()
    }
}

fun main() {
    println(2 days AGO)
    println(3 days FROM_NOW)
}