package com.kbh.study.`object`.observer

// Observer Pattern을 학습하며 코틀린에서의 익명객체의 활용을 학습한다.
// 직접적인 함수의 호출이 아닌 상황에서 특정 이벤트가 발생한 경우 즉각적으로 처리하는 패턴을 옵저버 패턴이라 부른다.
fun main() {
    EventPrinter().start()
    // EventPrinter가 EventListener를 override 하지 않아도 이벤트 객체를 Anonymous Object 로 넘길 수 있다.
    // 개인적으로 선호하지 않는 방식이므로 특별한 경우가 아니면 사용하지 않을것이다.
    AnonymousEventPrinter().start()
}