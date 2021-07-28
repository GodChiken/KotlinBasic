package com.kbh.study.coroutine

/**
 * 코루틴은 코틀린에서만 쓰이는 것이 아닌 다양한 분야에서 쓰이고 있다.
 * 비동기적인 프로세스를 처리하기 위해 메인이 되는 루틴에서 서브 역활을 하는 코루틴을 두어 개발자가 제어함에 목적이 있다.
 * 제어범위, 실행범위를 지정할 수 있고 이것을 스코프라고 한다.
 * 전체적인 스코프는 GlobalScope, 특정 목적을 위해는 CoroutineScope 를 통해 활용된다.
 * Scope 내에서 동작을 제어하기 위하여 여러종류의 Dispatcher 를 지정하여 활용하나 모든 플랫폼에서 지원하지 않으므로
 * 잘 확인하고 적용해야한다.
 * Scope에 반환값 유무에 따라 반환값이 없는 job 객체 launch, 반환값이 있는 Deffered async() 가 존재하고 람다함수의 형태를 취한다.
 * 튜토리얼성 2019년 강좌에서는 coroutine의 베이스 패키지가 kotlin 이었으나, kotlinx로 베이스 패키지가 변경됨을 확인했다.
 */
fun main() {
    //GlobalScope
}

class KotlinCoroutine