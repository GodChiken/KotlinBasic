package com.kbh.study.basic


/**
 * 코틀린에서 2가지의 동일성 체크가 있고 자바와 다른점을 체크해보자.
 * 그리고 자바와 혼동하지 말자
 *
 * java equals()    :   kotlin ==       structural equality(구조상의 동일성)
 *
 * java ==          :   kotlin ===      referential equality(참조상의 동일성)
 *
 * 코틀린의 "==" 는 자바의 equals() 와의 차이는 null 참조를 안전하게 다룬다
 *
 * 가령 자바에서의
 *
 * public static void main(String[] args) { Book book = null; System.out.println(book.equals("hi")); }
 *
 * 위와 같은 코드는 null에 대해서 대처할수 없다. 코틀린에서 추가적으로 항상 어떤 결과가 나오는지 경고 표시가 된다.
 *
 * 즉, 코틀린에서 "=="의 역활은 null check 이후 equals() 메서드를 실행한다.
 * */
class KotlinEquality

fun main() {
    println("hi" == null)
    println(null == "hi")
    println(null === null)
}