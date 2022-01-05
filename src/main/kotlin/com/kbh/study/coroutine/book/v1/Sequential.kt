package com.kbh.study.coroutine.book.v1

import kotlinx.coroutines.runBlocking

/**
 * 코루틴은 일급 객체다.
 * 코루틴은 언어에 만들어져 있지만 코루틴을 위한 편의 함수는 라이브러리에 포함되어있다.
 * 서브루틴에서 불가능한 기능(무한 시퀀스, 이벤트 루프, 협력함수 등)을 제공해준다.
 *
 * 순차적으로 실행되는 예제에서 코루틴을 사용한 동시실행 코드로 변경할 예정이다.
 * */

fun task1(i:Int = 1) {
    println("start task$i in Thread ${Thread.currentThread()}")
    println("end task$i in Thread ${Thread.currentThread()}")
}
fun task2(i:Int = 2) {
    println("start task$i in Thread ${Thread.currentThread()}")
    println("end task$i in Thread ${Thread.currentThread()}")
}
fun main() {
    println("start")

    run {
        task1()
        task2()
        println("called task1 and task2 from ${Thread.currentThread()}")
    }

    println("done.")
}

/*
start

start task1 in Thread Thread[main,5,main]
end task1 in Thread Thread[main,5,main]

start task2 in Thread Thread[main,5,main]
end task2 in Thread Thread[main,5,main]

called task1 and task2 from Thread[main,5,main]

done.
*/