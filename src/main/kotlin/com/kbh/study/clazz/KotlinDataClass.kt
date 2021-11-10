package com.kbh.study.clazz

fun main() {
    val a = General("경화",37)
    val b = KotlinDataClass("보훈",34)

    println(a == General("경화",37))
    println(a.hashCode())
    println(a)

    println()

    println(b == KotlinDataClass("보훈",34))
    // data class로 작성된 클래스는 == 연산자를 통해 비교해도 equals()와 동일한 기능을 수행하다.
    println(b.equals(KotlinDataClass("보훈",34)))
    println(b.hashCode())
    println(b.copy())
    // 한개만 적는 경우, 첫번쨰 파라미터를 인식하는 것으로 판단된다. IDE에서 어떤 파라미터를 넣는지 확인가능하다.
    println(b.copy("창현"))
    // 그러나 개인적으론 named argument 를 활용하여 표시하는것을 권장하고싶다.
    println(b.copy(name = "성인"))
    println(b.copy(age = 32))

    val list = listOf(
        KotlinDataClass("보훈",34),
        KotlinDataClass("경화",37),
        KotlinDataClass("창현",36),
        KotlinDataClass("보훈",32)
    )
    //
    for ((name,age) in list){
        println("$name, $age")
    }
}
class General (val name:String, val age:Int)

// 내용의 동일성을 판단하는 equals() 자동생성
// 객체의 고유한 코드를 생성하는 hashcode() 자동생성
// 객체의 프로퍼티를 쉽게 볼수있게 toString() 자동생성
// 객체를 복사하여 새 객체를 생성하도록하는 copy() 자동생성
// 순서대로 프로퍼티를 제공하는 componentX() 자동생성, X는 숫자를 의미한다. 탄생 목적은 직접 호출용이 아니라 컬렉션과 같은곳에 데이터 클래스가 담겨진 경우
// 내용을 꺼내쓰기 위한 용도로 지원되는 함수이다. 즉 Destructuring Declarations 활용 시 사용된다.
data class KotlinDataClass (val name:String, val age:Int)