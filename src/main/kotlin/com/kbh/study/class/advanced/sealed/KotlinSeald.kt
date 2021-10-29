package com.kbh.study.`class`.advanced.sealed

/**
 * 클래스 설계자가 지정한 클래스에만 상속하도록 하는 일종의 중간영역이 필요한 점에서 고안된 방법중 하나다.
 *
 * sealed 클래스는 동일한 파일에서 작성된 다른 클래스드렝 확장이 허용되지만 그외의 클래스들은 확장할 수 없는 클래스다.
 * sealed는 private로 생성자를 표기하지 않으나 private로 취급되기 때문에 다른 파일에서 인스턴스화 할수 없다.
 * 또한 자식클래스들은 여러개의 인스턴스를 생성할 수 있고, 프로퍼티와 메서드를 가질 수 있다.
 *
 * 하지만 자식클래스의 생성자를 private로 명시하지 않는다면 상속받은 클래스를 통해서 객체를 생성할 수 있다.
 *
 * */
sealed class Card(val suit:String)

class Ace(suit: String) : Card(suit)
class King(suit: String) : Card(suit) {
    override fun toString(): String {
        return "King of $suit"
    }
}
class Queen(suit: String) : Card(suit) {
    override fun toString(): String {
        return "Queen of $suit"
    }
}
class Jack(suit: String) : Card(suit) {
    override fun toString(): String {
        return "Jack of $suit"
    }
}
class Pip(suit: String, val number: Int) : Card(suit) {
    init {
        if (number < 2 || number > 10) {
            throw RuntimeException("Pip has to be between 2 and 10")
        }
    }
}

/**
 * sealed 클래스의 자식클래스의 인스턴스 생성은 간단하며 모든 자식클래스의 인스턴스 생성을 기술해야한다.
 * 그리고 when 표현식을 사용할 때 else를 사용하면 안된다. 새로운 자식클래스가 여러개 생겼을 경우
 * 누락해버린다면 컴파일 오류도 나타나지 않기때문에 프로그램이 의도치않게 실행될 여지가 있기 때문이다.
 * */

fun process(card: Card) = when (card){
    is Ace -> "${card.javaClass.name} of ${card.suit}"
    is King, is Queen, is Jack -> "$card"
    is Pip -> "${card.number} of ${card.suit}"
}

fun main(){
    println(process(Ace("Diamond")))
    println(process(Queen("Club")))
    println(process(Pip("Spades",2)))
    println(process(Pip("Hearts",6)))
}