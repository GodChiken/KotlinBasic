package com.kbh.study.`class`

/**
 * 클래스는 추상화를 나타내며 프리미티브 타입또한 동일하다.
 * 간단한 정보 일지라도 클래스와 프리미티브 타입에서 갈등을 생각하곤한다.
 * 가령 주민등록번호는 위 두가지 모두로 가능하다.
 * 클래스로 만들게 되면 명확하지나 프리미티브 타입으로 처리한 것보다 객체 생성과 메모리 사용에 관한 오버헤드기 발생한다.
 * 이런 점에 있어 inline class는 사용되는 기본 멤보로 확장되거나 대체된다.
 *
 * 1.프로퍼티와 메소드를 가질 수 있다.
 * 2.인터페이스를 받아 구현할 수 있다.
 * 3.초기화 블럭을 소유할 수 있다.
 * 4.다른 클래스에 의해 확장될 수 없다.
 *
 * 조금 더 파고들어 공부하고자 하면 다음과 같은 자료를 참고한다.
 * https://kotlinlang.org/docs/inline-classes.html#mangling
 * https://blog.jetbrains.com/ko/kotlin/2021/02/new-language-features-preview-in-kotlin-1-4-30/
 * */

inline class KotlinInlineClass (val name : String){
    /*이전엔 불가했으나 지금은 가능하다.*/
    init {
        require(name.isNotEmpty())
    }
}
@JvmInline
value class Color(val rgb : Int)

fun main() {

}