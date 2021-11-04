package com.kbh.study.delegation.lazy

/**
 * getTemperature() : 도시의 현재온도를 얻을 수 있는 함수, 작동에 시나리오는 다음과 같다.
 * - 사용시 마다 사용요금을 내야하며 딜레이가 있으므로 확실할 때만 호출한다.
 *
 * shortcircuit 때문에 애초에 실행이 되지 않는다. 어떻게보면 이외에도 실제로 필요할 때까지 실행하지 않도록 하는 방법이 있다.
 * lazy 래퍼함수를 사용하면된다.
 *
 * */
fun getTemperature(city: String): Double {
    println("fech from webservice for $city")
    return 30.0
}

fun main() {
    example1()
    example2()
}

private fun example1() {
    val showTemperature = false
    val city = "Boulder"
    if (showTemperature && getTemperature(city) > 20) {
        println("Warm")
    } else {
        println("Nothing to report")
    }
}
private fun example2() {
    val city = "Boulder"
    val showTemperature = false
    val temperature = getTemperature(city)

    if (showTemperature && temperature > 20) {
        println("Warm")
    } else {
        println("Nothing to report")
    }
}
/**
 * lazy  함수는 연산을 실행할 수있는 람다표현식을 아규먼트로 받는다.
 * */
private fun lazyWrapper() {
    val city = "Boulder"
    val showTemperature = false
    val temperature by lazy { getTemperature(city) }

    if (showTemperature && temperature > 20) {
        println("Warm")
    } else {
        println("Nothing to report")
    }
}
