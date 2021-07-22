package com.kbh.study.function.polymorphism

fun main() {
    /**
     * kotlin에서 up-casting은 상위 자료형에 대입하는것으로 끝난다.
     * 하지만 down-casting은 별도로 연산자를 통해 작업을 진행한다.
     * as, is 가 이에 해당된다.
     * as 는 변수를 호환되는 자료형으로 변환 해주는 캐스팅 연산자이다.
     * 사용 즉시 반영할 수 있고, 캐스팅하여 리턴하는 방식으로도 사용이 가능하다.
     * is 는 변수가 해당 자료형으로 호환이 되는지 체크한 이후에 반영하는 캐스팅 연산자이며 조건문 내에서 사용이된다.
     * */
    val a = Drink()
    a.drink()
    /**
     * as 키워드로 바로 형변환 이후 사용이 가능하다.
     */
    val b:Drink = Cola()
    b.drink()
    b as Cola
    b.washDishes()

    // is 를 사용하여 조건문 내에서 다운캐스팅이 가능한지 체크하고 if block에서 바로 다운캐스팅된 메서드를사용이 가능하다.
    val c:Drink = Cola()
    if (c is Cola){
        c.washDishes()
    }
}