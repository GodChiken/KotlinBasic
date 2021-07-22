package com.kbh.study.generic

class BlackBell : Bell() {
    override fun shout() {
        super.shout()
        println("검은색의 무언가가")
    }
}