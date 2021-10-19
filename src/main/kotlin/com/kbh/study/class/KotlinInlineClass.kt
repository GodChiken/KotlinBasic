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

inline class KotlinInlineClass(val name: String) {
    /*이전엔 불가했으나 지금은 가능하다.*/
    init {
        require(name.isNotEmpty())
    }
}

@JvmInline
value class Color(val rgb: Int)


/**
 * Inline classes vs type aliases
 * Inline class와 Type Alias 의 공통점 : 타입에 대해 새로운 이름을 부여하고, 런타임에 원래 타입으로 사용된다는 공통점이 있다.
 * Inline class와 Type Alias 의 차이점 : Type Alias는 기존 타입에 별칭을 부여하는 것이기 때문에 Alias 타입의 호환성이 보장되는 반면
 * Inline class는 기존 타입을 새로운 타입으로 구분짓기 때문에 호환되지 않는다.
 */
typealias NameTypeAlias = String

inline class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}

fun main() {
    val nameAlias: NameTypeAlias = ""
    val nameInlineClass: NameInlineClass = NameInlineClass("")
    val string: String = ""

    acceptString(nameAlias) // ok
    ///acceptString(nameInlineClass) // error

    // And vice versa:
    acceptNameTypeAlias(string) // ok
    //acceptNameInlineClass(string) // error
}