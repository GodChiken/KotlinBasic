package com.kbh.study.fluency.inject

/**
 * iterator() 메소드를 클래스로 인젝팅시 도움되는 사항
 *
 * 반복자를 만들떄 익명객체로 만들 수 있다. (객체 표현식으로 사용하는 익명객체)
 * start 속성을 이용하여 range 첫번째 요소에 접근이 가능하고 ClosedRange<T> 클래스의 endclusive를 이용하여 마지막 요소에 접근할 수 있다.
 * >= 사용시 compareTo() 실행된다.
 * 뮤터블 String을 사용하기 위해 StringBuilder룰 활용.
 *
 * */

operator fun ClosedRange<String>.iterator() =
    object : Iterator<String> {
        private val next = StringBuilder(start)
        private val last = endInclusive
        override fun hasNext() =
            last >= next.toString() && last.length >= next.length

        override fun next(): String {
            val result = next.toString()
            val lastCharacter = next.last()
            if (lastCharacter < Char.MAX_VALUE) {
                next.setCharAt(next.length - 1, lastCharacter + 1)
            } else {
                next.append(Char.MIN_VALUE)
            }
            return result
        }
    }

fun main() {
    for (word in "hell".."help"){
        print("$word, ")
    }
}