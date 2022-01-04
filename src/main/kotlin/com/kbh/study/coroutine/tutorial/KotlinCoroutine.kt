package com.kbh.study.coroutine.tutorial

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    // 전혀 실행되지 않음을 알 수 있다. 제어되는 스코프 및 프로그램이 종료가 되면 함께 종료가 된다.
    /*scope.launch {
        for (i in 1..10){
            println(i)
        }
    }*/
    /**
     * 일정한 범위 내에서 실행이 되도록 보장하려면 blocking 을 수행해야한다
     * cancel() 을 활용하여 코루틴을 2가지 경우로 따져서 종료시킬수 있다.
     * 1. delay(), yield() 가 사용된 위치까지 수행하되고 종료
     * 2. cancel()로 인하여 코루틴의 프로퍼티 isActive = false 가 되므로 이를 수동으로 확인하여 종료
     */
    /*runBlocking {
        val launch = launch {
            for (i in 1..10){
                println(i)
                delay(10)
            }
        }
        val async = async {
            println("async 종료")
        }
        println("async 대기")
        println(async.await())
        println("launch 대기")
        launch.join()
        println("launch 종료")
    }*/
    // 재시간내에 수행을 못하면 null 을 반환한다.
    runBlocking {
        val result = withTimeoutOrNull(50) {
            for (i in 1..10) {
                println(i)
                delay(10)
            }
            "finish" // return
        }
        println(result)
    }
}