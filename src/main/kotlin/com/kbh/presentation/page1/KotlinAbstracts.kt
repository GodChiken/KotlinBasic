package com.kbh.presentation.page1

fun main() {
    val bathRoom = BathRoom()
    val terrace = Terrace()
    bathRoom.enter()
    bathRoom.eat()
    terrace.enter()
    terrace.eat()
}


abstract class Room {
    abstract fun eat()
    fun enter(){
        println("방에 입장했다.")
    }
}

class BathRoom : Room() {
    override fun eat(){
        println("뭘 먹기엔 힘든 곳이다.")
    }
}

class Terrace : Room() {
    override fun eat(){
        println("고급과자를 먹는다.")
    }
}