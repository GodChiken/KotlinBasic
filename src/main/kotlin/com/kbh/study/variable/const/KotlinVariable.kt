package com.kbh.study.variable.const

/**
var, val 의 차이점은 학습이 되어있고 val의 유의점은 val로 선언된 변수의 프로퍼티에 대한 변조까지 막진 못한다.
하여 원천적으로 상수화 하고 싶은경우 const val 형태를 취하고 String을 포함한 기본자료형만 가능하다.
또한 클래스의 프로퍼티 혹은 지역변수로는 사용될수 없고 반드시 companion object 내에 선언하 객체의 생성과 관계없이
클래스와 관계된 고정값으로 사용된다.
 */
fun main() {
    val foodCourt = FoodCourt()

    foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PASTA)
    foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
    foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)
}