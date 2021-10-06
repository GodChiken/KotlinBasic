package com.kbh.study.generic


/**
 * receiveFruitsByArray 내에서 Fruit를 상속받는 Banana, Orage는 파라미터로 전달될 수 없다.
 * 이것을 코틀린에서 제공하는 제네틱에 대한 타입 불변성 때문에 발생한다.
 * 그리고 이것을 receiveFruitsByXXX 내에서 fruit parameter 가 특정 자식클래스로 전달되었는데
 * 형제 개념의 또 다른 자식클래스로 변경될 경우 같은 부모를 상속받는 클래스라 할지라도 동일하다고 취급될 수 없으므로 문제가 있는 코드가 생긴다.
 * 그렇기에 애초에 Array<T> 에서 전될되는 것을 막아 해당 제네릭을 타입에 대해서 안정적으로 취급될 수 있도록 만들어졌다.
 *
 * 하지만 List<T>는 자식타입으로 넘겨도 충분히 수용이 가능하다.
 * 이와같은 차이는 Array<T>와 List<T>가 뮤터블한지, 이뮤터블한지에 차이가 있다.
 *
 * public class Array<T>
 * public interface List<out E> : Collection<E>
 *
 * 좀 더 정확하게는 out 키워드로 인해서 공변성(covariance)을 사용하였기 때문이다.
 * 제네릭 베이스타입이 요구되는 곳에도 제네릭 파생타입이 허용되길 원하는 것이 공변성이고
 * 이럴때 타입 프로젝션(제네릭 클래스를 사용하는 관점에서 공변성을 이용하는 행위)
 * 혹은 사용처 가변성(use-site variance) 라고 불리는 행위가 필요하다.
 *
 *
 * copyFromTo() 는 공변성을 추가하지 않았기에 제네릭 파생타입을 넘길수 없다.
 * copyFromTo2() 는 from 에 out 키워드를 사용하여 공변성 파라미터를 사용하기 때문에 읽는 것은 가능하나 변경은 할수없다.
 * 이렇게 읽기만 하는경우 하위클래스가 전달되더라도 위험성이 적기 때문에 이와같은 것을 타입이나 파생타입에 접근하기 위한 파라미터 타입의 공변성이라 한다.
 * */


open class Fruit
class Banana : Fruit()
class Orange : Fruit()

fun receiveFruitsByArray(fruit: Array<Fruit>) {
    println("Number of fruits : ${fruit.size}")
    // 가령 이곳에서 fruit의 내용이 Orange() 인 경우 아래와 같은 행위를 한다면
    // 리스코프 치환의 원칙에 어긋나는 행위
    fruit[0] = Banana()
}

fun receiveFruitsByList(fruit: List<Fruit>) {
    println("Number of fruits : ${fruit.size}")
}

fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun copyFromTo2(from: Array<out Fruit>, to: Array<Fruit>) {
    for (i in from.indices) {
        //from[i] = Fruit() // complie error
    }
}

fun main() {
    val bananaArray: Array<Banana> = arrayOf()
    val orangeList: List<Orange> = listOf()

    //receiveFruitsByArray(bananaArray) : type mismatch
    receiveFruitsByList(orangeList)

    val fruitArray: Array<Fruit> = arrayOf()
    val fruitList: List<Fruit> = listOf(Orange(), Orange())

    fruitArray.plus(Orange())
    //fruitList = fruitList + Orange()

    val fruitBasket1 = Array(3) { _ -> Fruit() }
    val fruitBasket2 = Array(3) { _ -> Fruit() }
    val bananaBasket = Array(3) { _ -> Banana()}
    copyFromTo(fruitBasket1, fruitBasket2)
    //copyFromTo(bananaBasket, fruitBasket1) type mismatch
    copyFromTo2(bananaBasket, fruitBasket1)
}