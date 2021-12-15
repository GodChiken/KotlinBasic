package com.kbh.study.dsl

/**
 * 간단한 경우에는 확장함수를 활용해서 해결하면 그만이나 다음과 같은 예제는 고민을 해야한다.
 *
 *
 * infix fun String.meeting(block: () -> Unit){
 *      println("step1")
 * }
 * Release Planning" meeting {}
 *
 * 처음 meeting()을 String클래스의 확장함수로 인젝트 후 infix도 추가하여 '.'을 제거했다.
 * 람다 내부에서 meeting 시간에 대한 세부사항을 업데이트 해야한다.
 *
 * Class Meeting
 * infix fun String.meeting(block: Meeting.() -> Unit){
 *      val meeting = Meeting()
 *      meeting.block()
 *      println(meeting)
 * }
 * Release Planning" meeting {}
 *
 * 상태 업데이트를 위한 Meeting 클래스를 선언한다.
 *
 * infix fun String.meeting(block: Meeting.() -> Unit){
 *      val meeting = Meeting(this)
 *      meeting.block()
 *      println(meeting)
 * }
 *
 * meeting()는 block 파라미터는 Meeting 타입의 리시버를 받게된다.
 * 메서드 내부에서는 인스턴스를 만들고 이 인스턴스의 컨텍스트에서 람다를 실행하고 출력한다.
 * 출력하면 String.meeting()에서 생성된 인스턴스가 람다 표현식 내부의 리시버인 this와 동일하다.
 *
 * class Meeting(val title: String){
 *      var startTime: String =""
 *      var endTime: String =""
 *      private fun convertToString(time: Double) = String.format("%.02f",time)
 *      infix fun at(time: Double) { startTime = convertToString(time)}
 *      infix fun by(time: Double) { endTime = convertToString(time)}
 *      override fun toString() = "$title Meeting starts ${start.time} ends ${end.time}"
 * }
 *
 * "Release Planning" meeting {
 *      this at 14.30
 *      this by 15.20
 * }
 *
 * Meeting 내에 at(),by()를 만들고 람다안에서 둘다 수행하도록 구성.
 * 그리고 회의 제목도 받을 수 있도록 생성자 파라미터를 구성.
 * 점과 괄호를 제거하기 위한 infix도 메서드에 같이 구성.
 * 잠시 객체 참조를 위해 this 를 사용히야 암시적 리시버를 명시적 리시버로 활용한다.
 * "this (method) (value)" 이런 포맷으로 적게되면 직관적이 못하므로 각각의 this를 start, end변수를 만들어 바인딩한다.
 *
 * class Meeting(val title: String){
 *      var startTime: String =""
 *      var endTime: String =""
 *      val start = this
 *      val end = this
 *
 *      private fun convertToString(time: Double) = String.format("%.02f",time)
 *      infix fun at(time: Double) { startTime = convertToString(time)}
 *      infix fun by(time: Double) { endTime = convertToString(time)}
 *      override fun toString() = "$title Meeting starts ${start.time} ends ${end.time}"
 * }
 *
 * "Release Planning" meeting {
 *      start at 14.30
 *      end by 15.20
 * }
 *
 * 이제 원하는대로 구성이 다 된듯하나, 한가지 문제점을 더 해결해야한다.
 * 현재 코드느 start by, end at 과 같이 의도에 벗어나게 호출하는 것을 막을 수 없다.
 * 이를 해결하려면 클래스로 분리해야한다.
 *
 * */

open class MeetingTime(var time: String = ""){
    protected fun convertToString(time: Double) = String.format("%.02f",time)
}
class StartTime : MeetingTime() {
    infix fun at(theTime: Double) { time = convertToString(theTime) }
}
class EndTime : MeetingTime() {
    infix fun by(theTime: Double) { time = convertToString(theTime) }
}

class Meeting(val title: String){
    var start = StartTime()
    var end = EndTime()
    override fun toString() = "$title Meeting starts ${start.time} ends ${end.time}"
}

infix fun String.meeting(block: Meeting.() -> Unit){
    val meeting = Meeting(this)
    meeting.block()
    println(meeting)
}

fun main() {
    "Release Planning" meeting {
        start at 14.30
        end by 15.20
    }
}
