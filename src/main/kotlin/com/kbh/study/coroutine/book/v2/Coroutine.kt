package com.kbh.study.coroutine.book.v2

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

    /**
     * 이전 시퀀셜한 코드와 동일하다.
     * 코루틴은 코드를 동시에 수행시키므로 람다 안의 코드는 runBlocking() 호출 이전코드와
     * 해당 함수 호출 이후의 코드사이에서 끼워맞춰진(interleaved) 메인 스레드에서 실행된다.
     * */
    /*runBlocking {
        task1()
        task2()
        println("called task1 and task2 from ${Thread.currentThread()}")
    }*/

    /**
     * launch() 함수는 주어진 람다를 실항하기 위해서 새로운 코루틴을 시작한다.
     * 실행되는 코드가 코루틴의 완료를 위해서 블록되지 않는다는 저믈 제외하면 runBlocking()와 비슷하다.
     * runBlocking()와 다르게 job을 리턴하고 완료를위해 기다리거나 취소하는데 사용할 수 있다.
     *
     * 모든 코드는 메인 스레드에서 실행됬다.
     * */
    runBlocking {
        launch { task1() }
        launch { task2() }
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
/*
start

called task1 and task2 from Thread[main,5,main]

start task1 in Thread Thread[main,5,main]
end task1 in Thread Thread[main,5,main]

start task2 in Thread Thread[main,5,main]
end task2 in Thread Thread[main,5,main]

done.
*/