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
 *
 * main()에 runBlocking<Unit> 단일표현식 함수를 할당했다. 지금까지 우리는 runBlocking()을 Unit 파라미터 없이 사용했다.
 * main()은 Unit을 리턴하기 때문에 파라미터에 Unit을 기입하여 동일한 리턴타입을 가지도록 해야한다.
 *
 * 코드의 결과를 보게되면 중간에 스레드가 스위칭되는것을 확인할 수있다. delay() 전후로 다른 스레드에서 작동한다.
 * 이것을 바로 컨티뉴에이션이라고 한다.
 *
 * 컨티뉴에이션을 활용하면 한 스레들에서 실행상태를 포착(capture)하고 보존(preserve)할 수 있다.
 * 그리고 이 상태를 다른 스레드에서 필요로 할때 불러올 수있다.
 * 컨티뉴에이션을 제공해주는 프로그래밍 언어는 프로그래머를 위해 자연스럽게 실행하기 위한 특별한 코드를 생성한다.
 *
 * 컨티뉴에이션은 렉시컬 스코프를 캡처하는 클로저라고 생각하자.(클로저와 렉시컬 스코핑 확인)
 * 서스펜션 포인트 이후에 어떻게 코드가 클로저로 감싸지고 저장되는지 상상해볼 수 있다.
 * 클로저는 함수 실행이 재개 되어ㅑ하는 경우 언제든지 실행될 수 있다.
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