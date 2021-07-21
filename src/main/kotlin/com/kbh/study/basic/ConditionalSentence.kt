package com.kbh.study.basic

class ConditionalSentence {
    var a = 7
    fun conditionalExample(){
        if(a>10){
            println("크다")
        }else{
            println("작다")
        }
    }
}

fun main() {
    val conditionalSentence = ConditionalSentence()
    conditionalSentence.conditionalExample()
}