package com.kbh.study.coroutine.book.v7

import kotlinx.coroutines.*
/**
 * launch() 함수는 Job 객체를 리턴하여 코루틴의 종료를 기다리거나 취소를 기다리기 위해서 사용된다.
 * 그러나 결과를 리턴받을 방법이 없다.
 *
 * 비동기로 실행하면서 결과도 받고싶은 경우 async()를 사용한다. 그리고 이는 파라미터가 동일하다.
 * Deferred<T>  퓨처(future) 객체를 리턴한다.
 * 퓨처 객체는 코루틴의 상테체크, 취소 등을 할수있는 await() 메소드를 가지고 있는 객체다.
 *
 * await()는 스레드의 실행은 차단하지 않음녀서 실행의 흐름을 차단한다.
 * 이와같은 개념으로 동작하기에 호출자의 코드와 async()로 실행된 코루틴의 코드는 동시 실행이 가능하다.
 * await()는 async()로 시작된 코루틴의 결과를 리턴받는다. 예외 처리의 전파 또한 마찬가지다.
 *
 * async()의 파라미터를 생략하는경우 상속받은 스코프의 디스패처에서 실행된다.
 *
 * 본 예제에서 싱글 스레드 스코프를 사용하고 코루틴은 호출자와 동일한 스레드에서 동작하게한다.
 * 멀티 스레드 디스패처의 스코프에서 동작하게 구성한다면 해당 디스패처의 스레드 중 하나에서 동작한다.
 *
 * async()의 첫 인자를 생략하면 위에 개념에서 보였듯이 main 스레드에서 동작한다.
 *
 * 고로 코루틴은 비동기로 실행되고, 스레드를 스위칭, 중단 및 재시작을 할 수 있다.
 *
 * */

fun main() {
    //Coroutine DefaultDispatcher Pool
    runBlocking {
        val count: Deferred<Int> = async(Dispatchers.Default) {
            println("fetching in ${Thread.currentThread()}")
            Runtime.getRuntime().availableProcessors()
        }

        println("Called the function in ${Thread.currentThread()}")
        println("Number of cores is ${count.await()}")
    }

    //main 스레드에서 동작
    runBlocking {
        val count: Deferred<Int> = async() {
            println("fetching in ${Thread.currentThread()}")
            Runtime.getRuntime().availableProcessors()
        }

        println("Called the function in ${Thread.currentThread()}")
        println("Number of cores is ${count.await()}")
    }
}