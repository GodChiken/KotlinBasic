package com.kbh.study.`object`.observer


class AnonymousEventPrinter {
    fun start(){
        val counter = Counter(object: EventListener{
            override fun onEvent(count: Int) {
                print("$count-")
            }
        })
        counter.count()
    }
}