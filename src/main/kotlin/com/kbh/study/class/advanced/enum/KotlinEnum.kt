package com.kbh.study.`class`.advanced.enum

enum class Suit(val symbolText: Char) {
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665'){
        override fun display() = "${super.display()} $symbolText"
    },
    SPADES('\u2660');
    open fun display() = "$symbolText $name"
}
sealed class Card(val suit: Suit)
class Ace(suit: Suit) : Card(suit)
class King(suit: Suit) : Card(suit) {
    override fun toString(): String {
        return "King of $suit"
    }
}

class Queen(suit: Suit) : Card(suit) {
    override fun toString(): String {
        return "Queen of $suit"
    }
}

class Jack(suit: Suit) : Card(suit) {
    override fun toString(): String {
        return "Jack of $suit"
    }
}

class Pip(suit: Suit, val number: Int) : Card(suit) {
    init {
        if (number < 2 || number > 10) {
            throw RuntimeException("Pip has to be between 2 and 10")
        }
    }
}

fun process(card: Card) = when (card) {
    is Ace -> "${card.javaClass.name} of ${card.suit}"
    is King, is Queen, is Jack -> "$card"
    is Pip -> "${card.number} of ${card.suit}"
}

fun main() {
    println(process(Ace(Suit.DIAMONDS)))
    println(process(Queen(Suit.CLUBS)))
    println(process(Pip(Suit.SPADES, 2)))
    println(process(Pip(Suit.HEARTS, 6)))

    for (suit in Suit.values()){
        println(suit.display())
    }
}