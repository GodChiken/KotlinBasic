package com.kbh.study.coroutine.book.v3

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * 코틀린내 코루틴은 서스펜션 포인트(중단점)을 포함하고 있다.
 * 서스펜션 포인트란 현재 실행중인 작업을 중지시키고 다른 작업을 실행하는 함수를 의미한다.
 *
 * 이를 다루기위해 delay(), yield() 등에 대해서 학습한다.
 *
 * delay() : 현재 실행 중인 작업을 지정된 밀리초만큼 중단.
 * yield() : Unix기반의 nice 커맨드(시스템 프로세스의 우선순위를 낮추는)와 유사.
 *
 * 서스펜션 포인트를 사용하려면 'suspend' 키워드를 활용해야 권한이 주어진다.
 *
 * 이전과의 차이는 확실히 task1, task2 사이의 yield()를 통한 넘겨주기를 통해 작업전환이 되는 것이 확인된다.
 * 이전 예제는 싱글스레드 main이 모든 코드를 실행시키면서 함수 실행은 순차적으로 하지 않았는지 보여졌다.
 * 실행의 인터리빙을 명확하게 볼 수 있었고 간단하게 동시 실행의 예를 확인했다.
 * */

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
        launch { task1() }
        launch { task2() }
        println("called task1 and task2 from ${Thread.currentThread()}")
    }

    println("done.")
}
/*
start

called task1 and task2 from Thread[main,5,main]

start task1 in Thread Thread[main,5,main]
start task2 in Thread Thread[main,5,main]

end task1 in Thread Thread[main,5,main]
end task2 in Thread Thread[main,5,main]

done.
*/
