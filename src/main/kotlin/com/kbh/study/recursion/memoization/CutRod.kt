package com.kbh.study.recursion.memoization

import com.kbh.study.recursion.memoization.delegate.Memoize

/**
 * 동적 프로그래밍(다이나믹 프로그래밍)은 메모이제이션을 이용해서 재귀호출을 효율적으로 만드는 알고리즘이다.
 * 캐싱하고 함수호출의 결과를 다시 사용하는 방법으로 다이나믹 프로그래밍은 반복적인 재귀함수 호출을 제거한다.
 * 그래서 복잡도를 많이 낮출 수 있다.
 *
 * Memoize 델리게이트를 적용해서 다이나믹 프로그래밍의 유명한 문제인 막대 자르기 문제를 해결하기로한다.
 * 주어진 위치에 숫자가 하나만 있는 피보나치와 다르게 최적화 문제라고 불리는 문제들은 여러 솔루션이 나올 수 있다. *
 * 다이나믹 프로그래밍은 최적화(optimization) 문제를 위해서 가능한 솔루션들을 재귀적으로 탐색하는데 사용된다.
 *
 * 막대의 길이마다 가겨이 다르다. 막대기를 주어진 길이로 잘라서 판매자가 최대의 수익을 낼 수있는 길이의 막대기로
 * 만드는 방법을 찾는 문제이다.
 *
 * 가령 길이 '4' 막대를 그냥팔면 7달러에 수입을 올리나, '1'로 잘라서 팔면 8달러의 수입을 올릴 수 있다.
 * 최적의 수입을 얻을수 있는 법을 찾는것이다.
 *
 * */

/*
pseudocode

maxPrice(length) =
    max {
        maxPrice(1) + maxPrice(length - 1),
        maxPrice(2) + maxPrice(length - 2),
        ...,
        maxPrice(length - 1) + maxPrice(1),
        price[length]
   }
*/


val prices = mapOf(1 to 2, 2 to 4, 3 to 6, 4 to 7, 5 to 10, 6 to 17, 7 to 17)

//pseudocode 적용
/**
 * prices.getOrDefault(length, 0) // 해당 길이가 없으면 0 리턴
 * 1 until length // 1에서 length-1 까지
 * fold() : 초기값 할당후 집계
 * Math.max() : 대소 비교후 큰값 리턴
* */
val maxPrice: (Int) -> Int by Memoize { length: Int ->
    val priceAtLength = prices.getOrDefault(length, 0)
    (1 until length).fold(priceAtLength) { max, cutLength ->
        val cutPrice = maxPrice(cutLength) + maxPrice(length - cutLength)
        Math.max(cutPrice, max)
    }
}

fun main() {
    for (i in 4..7) {
        println("For length $i max price is ${maxPrice(i)}")
    }
    println(prices.getOrDefault(10,0))
}