package com.kbh.study.coroutine.book.v6

import kotlinx.coroutines.*
import java.util.concurrent.Executors

/**
 * 서스펜션 포인트 이후에 스레드 스위칭
 *
 * 호출자의 컨텍스트에서 서스펜션 포인트 이후에 다른 스레드로 스위칭을 하고싶은경우가 있다.
 * 시간이 걸리는 연산을 하는 인스턴스라면 다른 스레드로 실행을 델리게이트 하고 싶을것이다.
 * CoroutineStart 아규먼트와 CoroutineContext 아규먼트를 사용하여 수행할 수 있다.
 *
 * 코루틴을 현재 컨텍스트에서 실행시키기 위해서 launch()의 두번째 옵셔널 전달인자인 CoroutineStart를 DEFAULT로 설정해야한다.
 * DEFAULT: 현재 컨텍스트에서 실행
 * LAZY: 명시적으로 start()가 호출되기 전까지 실행을 연기
 * ATOMIC: 중단없는 모드로 수행
 * UNDISPATCHED: 현재 컨텍스트에서 실행되지만 서스펜션 포인트 이후에 스레드를 스위치해서 수행한다.
 *
 * UNDISPATCHED는 아직까지 실험적인 기능이며, 사용하기위해서 @UseExperimental 어노테이션을 적어야한다.
 * @UseExperimental 을 사용하지만 deprecate 됬으므로 @OptIn 어노테이션을 사용한다.
 *
 * 책에서는 command 라인에 적어서 컴파일 옵션을 넣어서 다음과 같은 @OptIn의 경고를 없앤다.
 * "This class can only be used with the compiler argument '-Xopt-in=kotlin.RequiresOptIn'"
 *
 * intellij, gradle 프로젝트 기준으로 build.gradle.kts에서 freeCompileArgs 에 옵션을 추가해야한다.
 * Compiler option : -Xopt-in=kotlin.RequiresOptIn
 *
 * 여러 시도에 버전업하여 시도해봤으나 커맨드에서 실행하는 법도 애매하다.
 * command : kotlinc-jvm -opt-in=kotlin.Experimental
 *                       -classpath (코루틴 코어 jar path)
 *                       -script (실행 스크립트)
 * 코루틴 코어 jar path : ~/.gradle/caches/jars-8/c32d2d72b023e8a58bb09d62dfff1c3a/kotlinx-coroutines-core-1.3.8.jar
 * 실행 스크립트 : ./src/main/kotlin/com/kbh/study/coroutine/book/v6/CoroutineStart.kt
 *
 * 커뮤니티에 질문 후 최신화
 *
 * */

suspend fun task1(i: Int = 1) {
    println("start task$i in Thread ${Thread.currentThread()}")
    yield()
    println("end task$i in Thread ${Thread.currentThread()}")
}

suspend fun task2(i: Int = 2) {
    println("start task$i in Thread ${Thread.currentThread()}")
    yield()
    println("end task$i in Thread ${Thread.currentThread()}")
}

fun main() {

    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        .asCoroutineDispatcher().use { context ->
            println("start")

            runBlocking {
                //실험적인 라이브러리 사용시 기술
                @OptIn(ExperimentalCoroutinesApi::class)
                launch(
                    context = context,
                    start = CoroutineStart.UNDISPATCHED
                ) { task1() }
                launch { task2() }
                println("called task1 and task2 from ${Thread.currentThread()}")
            }

            println("done.\n\n")
        }

    runBlocking {
        println("starting in Thread ${Thread.currentThread()}")
        withContext(Dispatchers.Default) { task1() }
        launch { task2() }
        println("ending in Thread from ${Thread.currentThread()}")
    }
}
//서스펜션 포인트 이후에 스레드 스위칭
/*
starting in Thread Thread[main @coroutine#1,5,main]
start task1 in Thread Thread[DefaultDispatcher-worker-1 @coroutine#1,5,main]
end task1 in Thread Thread[DefaultDispatcher-worker-3 @coroutine#1,5,main]
ending in Thread from Thread[main @coroutine#1,5,main]
start task2 in Thread Thread[main @coroutine#2,5,main]
end task2 in Thread Thread[main @coroutine#2,5,main]
*/
//코루틴 컨텍스 변경
/*
running in Thread Thread[main @top#1,5,main]
start task1 in Thread Thread[DefaultDispatcher-worker-1 @top#1,5,main]
end task1 in Thread Thread[DefaultDispatcher-worker-3 @top#1,5,main]
start task2 in Thread Thread[DefaultDispatcher-worker-3 @task#2,5,main]
end task2 in Thread Thread[DefaultDispatcher-worker-3 @task#2,5,main]
running in Thread from Thread[main @coroutine#1,5,main]
*/
