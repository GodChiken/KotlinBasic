package com.kbh.study.variable.const

class FoodCourt {
    fun searchPrice(foodName: String) {
        val price = when (foodName) {
            FOOD_CREAM_PASTA -> 13000
            FOOD_STEAK -> 25000
            FOOD_PIZZA -> 15000
            else -> 0
        }
        println("$foodName 의 가격은 $price 입니다.")
    }

    companion object {
        const val FOOD_CREAM_PASTA = "크림 파스타"
        const val FOOD_STEAK = "스테이크"
        const val FOOD_PIZZA = "피자"
    }
}