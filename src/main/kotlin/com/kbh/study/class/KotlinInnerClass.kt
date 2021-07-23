package com.kbh.study.`class`

// kotlin에서의 Inner Class 는 상위 클래스 내에 하위 클래스가 연관이 되어있다는 점을 이야기 하는 것일뿐
// 외부 클래스의 구성요소를 공유하며 내부 클래스 자체로 객체를 생성할 수 없고 외부 클래스의 객체를 통해 생성이 가능다.
fun main() {
    val room:Home.Room = Home().Room()
    println(room.roomWatt)
    println(room.singleRoomWatt)
}
class Home {
    val watt: Int = 100
    inner class Room {
        private var watt = 200
        //외부와 내부의 변수가 중복된 경우 다음과 같이 활용이 가능하다.
        val roomWatt: Int = this@Home.watt / 10
        val singleRoomWatt: Int = watt / 10
    }
}
