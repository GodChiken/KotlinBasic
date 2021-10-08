package com.kbh.study.generic

import java.io.StringWriter
import java.lang.Appendable


/**
 * where 키워드를 활용한 타입 파라미터의 제한하는 법을 학습한다.
 * 우리는 특정 타입 T가 메서드내에 사용되는 기능을 전부 지원할 수 있다고 장담할수 없다.
 * 그래서 where 키워드를 사용하면 특정 메소드가 있는 타입만 접근이 가능하도록 설정할 수 있다.
 *
 * 또한 하나만 제한이 되는 것이 아니라 여러개의 제약조건을 넣는 것이 가능하다.
 * */

fun <T> useAndClose(input :T)
where T: AutoCloseable,
      T: Appendable{
 input.append("there")
 input.close()
}

fun main() {
    val writer = StringWriter()
    writer.append("hello ")
    useAndClose(writer)
    println(writer)
}