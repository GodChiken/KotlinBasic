package com.kbh.study.coroutine.book.v8

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * suspend 어노테이션으로 표시된 메서드는 데이터를 리턴할 수 있다.
 * 코루틴은 작동을 중단 시킬수도 스레드를 변경할 수도 있으며 상태가 스레드 사이에서 보존 및 전파가 되는지 학습해야된다.
 *
 * 2개의 메서드는 역활은 동일하나 compute2()는 실행의 플로우를 다른 지연된 작업에 양보하고 실행 중 스레드가 변경될 가능성이 있다.
 * 2번 실행해서 확인해본다.
 * */

class Compute {
    fun compute1(n: Long): Long = n * 2
    suspend fun compute2(n: Long): Long {
        val factor = 2
        println("$n received : Thread : ${Thread.currentThread()}")
        delay(n * 1000)
        val result = n * factor
        println("$n, returning $result: Thread : ${Thread.currentThread()}")
        return result
    }
}

fun main() = runBlocking<Unit> {
    val compute = Compute()
    launch(Dispatchers.Default) {
        compute.compute2(2)
    }
    launch(Dispatchers.Default) {
        compute.compute2(1)
    }
}