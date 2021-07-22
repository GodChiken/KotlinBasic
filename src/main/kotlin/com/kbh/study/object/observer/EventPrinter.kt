package com.kbh.study.`object`.observer

class EventPrinter : EventListener{
    override fun onEvent(count: Int) {
         print("${count}-")
    }
    fun start(){
        val counter = Counter(this)
        counter.count()
    }
}