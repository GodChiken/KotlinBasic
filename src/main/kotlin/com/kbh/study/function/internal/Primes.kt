package com.kbh.study.function.internal

fun main() {
    /**
     * 무한 시퀀스
     *
     * 성능적인 장점외에도 지연연산은 온디맨드 연산에도 도움이 된다.
     * 피보나치 혹은 짝수로 증가하는 시퀀스가 있다고 가정해보고, 이를 생성하려면 몇가지 방법이 있다.
     *
     * */
    println(primes.take(6).toList())
    println(primesBySequence.drop(2).take(6).toList())
}

// 숫자가 주어졌을때 소수인지 여부를 판단
fun isPrime(n: Long) = n > 1 && (2 until n).none { i -> n % i == 0L }

// 숫자를 받고 다음 소수를 리턴, StackOverFlow를 방지하기 위하여 tailrec 활용
tailrec fun nextPrime(n: Long): Long =
    if (isPrime(n + 1)) n + 1 else nextPrime(n + 1)

// 주어진 숫자로 시작하는 소수의 무한 시퀀스 생성
val primes = generateSequence(5, ::nextPrime)

// sequence로 컨티뉴에이션 람다를 받는다. yield() 는 값을 호출자에게 리턴하고 다음 코드를 실행하는 요소로 생각해본다.
val primesBySequence = sequence {
    var i: Long = 0
    while (true) {
        i++
        if (isPrime(i)){ yield(i) }
    }
}