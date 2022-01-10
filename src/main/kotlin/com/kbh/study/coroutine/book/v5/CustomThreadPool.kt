package com.kbh.study.coroutine.book.v5

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import java.util.concurrent.Executors

/**
 * Custom Pool 실행시키기
 *
 * 코루틴을 싱글 스레드 풀에서 실행시키고자한다면 가능하다.
 * 싱글 스레드이기때문에 어찌됬든 병렬이 아니라 동시 실행으로 진행된다.
 *
 * 이렇게 해서 자원 경쟁에 대해서 학습 시 사용한다.
 *
 * asCoroutineDispatcher()는 확장함수를 통해 CoroutineContext를 가져올 수 있다.
 * 실행자를 닫지 않으면 프로그램은 멈추지 않는다. 실행자의 풀에는 main 스레드 외에도 액티브 스레드가 있고 JVM을 계속 살려둔다.
 * 모든 코루틴이 끝나고 실행자를 닫는지 체크가 되어야되는데 use()가 이 역활을 한다.
 *
 * Java의 try-with-resources 기능과 유사하다.(https://ryan-han.com/post/java/try_with_resources/)
 *
 * 람다 내부에서 context 변수를 통해 컨텍스트 참조에 대해서 획득했고, 이것을 task1()을 실행하면 커스텀 풀에서 실행이 가능하다.
 *
 * 시스템에 코어와 동일하게 스레드 풀을 구성하려면 newFixedThreadPool()을 활용하자.
 *
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

    //single
    Executors.newSingleThreadExecutor().asCoroutineDispatcher().use { context ->
        println("start")

        runBlocking {
            launch(context) { task1() }
            launch { task2() }
            println("called task1 and task2 from ${Thread.currentThread()}")
        }

        println("done.")
    }

    //multiple
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).asCoroutineDispatcher().use { context ->
        println("start")

        runBlocking {
            launch(context) { task1() }
            launch { task2() }
            println("called task1 and task2 from ${Thread.currentThread()}")
        }

        println("done.")
    }
}
/*
start

start task1 in Thread Thread[pool-1-thread-1,5,main]
end task1 in Thread Thread[pool-1-thread-1,5,main]

called task1 and task2 from Thread[main,5,main]

start task2 in Thread Thread[main,5,main]
end task2 in Thread Thread[main,5,main]

done.
*/