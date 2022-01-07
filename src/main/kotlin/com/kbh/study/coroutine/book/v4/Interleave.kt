package com.kbh.study.coroutine.book.v4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * 컨텍스트의 명시적 세팅
 *
 * 기본적으로 launch(), runBlocking() 함수를 호출하면 호출자의 코루틴 스코프와 같은 스레드에서 코루틴을 수행한다.
 * 왜냐하면 함수들이 함수의 스코프에서 코루틴 컨텍스트를 옮기기 떄문이다. 그리고 실행의 컨텍스트와 스레드를 원하는 곳으로 변경이 가능하다.
 *
 * CoroutineContext를 launch(), runBlocking() 함수에 전달해서 컨텍스트를 설정할 수 있다.
 *
 * CoroutineContext의 아규먼트인 Dispatchers.Default 값이 코루틴에게 DefaultDispatcher Pool의 스레드에서 수행하도록 지시한다.
 * 숫자가 2개인 경우와 시스템의 코어 숫자중 높은 것을 사용한다. DefaultDispatcher Pool은 계산할 일이 많은 작업을 위한 풀이다.
 *
 * Dispatcher.IO의 값은 IO작업을 실행을 하기위한 풀 안의 코루틴을 실행시키는데 사용될 수있다.
 * 이 풀은 스레드가 IO에 블록될 경우와 작업이 더 생성된 경우 사이즈가 커질 수 있다.
 *
 * Dispatcher.Main은 안드로이드 기기 및 Swing UI와 같은데서 사용된다.
 * 사용되는 예는 main 스레드에서 사용되는 UI 업데이트 기능을 활용하는 것이다.
 *
 * task1()의 컨텍스트를 수정하면 다른 스레드에서 수행한다. 병렬 실행되는 멀티플 스레드는 순서가 보장이 안된다.
 * task1()은 병렬, task2()와 람다 내부의 코드는 동시성을 가지고 수행한다.
 * 위와같은 상황은 컨텍스트에 따라 달라진다.
 * * */

suspend fun task1(i:Int = 1) {
    println("start task$i in Thread ${Thread.currentThread()}")
    yield()
    println("end task$i in Thread ${Thread.currentThread()}")
}
suspend fun task2(i:Int = 2) {
    println("start task$i in Thread ${Thread.currentThread()}")
    yield()
    println("end task$i in Thread ${Thread.currentThread()}")
}
fun main() {
    println("start")

    runBlocking {
        launch(Dispatchers.Default) { task1() }
        launch { task2() }
        println("called task1 and task2 from ${Thread.currentThread()}")
    }

    println("done.")
}
/*
start

start task1 in Thread Thread[DefaultDispatcher-worker-1,5,main]
end task1 in Thread Thread[DefaultDispatcher-worker-1,5,main]

called task1 and task2 from Thread[main,5,main]

start task2 in Thread Thread[main,5,main]
end task2 in Thread Thread[main,5,main]

done.
*/
