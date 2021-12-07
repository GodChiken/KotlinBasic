package com.kbh.study.fluency

/*
*
* 람다 표현식을 받고 실행하여 객체를 리턴하는 4가지의 메서드가 존재한다.
* also(), apply(), let(), run() 이 존재한다.
*
* result = context.oneOfTheseFourMethods { optionalParameter - >
*   ...body ...
*   ...this(reciver) ...
*   optionalResult
* }
*
* optionalParameter와 this(메소드를 호출하는 리시버)는 호출한 메소드에 다라서 다르게 할당되므로 optionalResult 또한 다르다.
*
* 위 함수를 쓰므로써 코드를 간결하고 표현력 있게 만들수 있다.
*
* let() 컨택스트 객체(let()을 호출한 객체)를 인자로 람다에 전달한다. 람다의 this(혹은 리시버)의 스코프는 렉시컬 스코프이며 this는 람다가 정의된 스코프에 바인딩된다.
* 람다가 리턴한 결과가 호출 결과로 나온다.
* also() 는 let()과 동일하나 차이점은 result를 무시하고 컨텍스트 객체를 결과로 리턴한다. 리턴타입이 Unit이기 때문이다.
* run() 메소드는 람다에 아규먼트를 전달하지 않는다. 하지만 run()을 호출하는 컨텍스트 객체를 람다의 this에 바인딩한다 람다가 리턴한것이 결과이다.
* apply() 메소드는 run()과 전반적으로 동일하나 차이점은 람다의 결과를 무시하고 컨텍스트 객체를 호출자에 리턴한다.
*
* 4개의 메소드 모두 전달받은 람다를 실행한다.
* let(), run()은 람다를 실행시키고 람다의 결과를 리턴한다.
* also(), apply()는 람다의 결과를 무시하고 컨텍스트 객체를 호출한 곳으로 리턴한다.
* run(), apply()는 호출한 컨텍스트 객체의 실행 컨텍스를 this로 사용하여 실행시킨다.
*
* 허나, 현재 실습코드에서 let과 also에 this를 사용할 수 없고, 사용할 수 있다고해도, 사용자 정의된 toString()과 무슨 상관이 있는지 잘 모르겠다.
*
* */


//Method    Argument  Reciver   Return    Result
// ===============================================
//let       context   lexical   RESULT    RESULT
//also      context   lexical   RESULT    context
//run       N/A       context   RESULT    RESULT
//apply     N/A       context   RESULT    context

fun main() {
    val format = "%-10s%-10s%-10s%-10s"
    val str = "context"
    val result = "RESULT"
    fun toString() = "lexical"

    println(String.format("%-10s%-10s%-10s%-10s%-10s",
        "Method","Argument","Receiver","Return","Result"))
    println("===============================================")


    /*val result1 = str.let { arg ->
        print(String.format(format, "let", arg, this, result))
        result
    }
    println(String.format("%-10s", result1))

    val result2 = str.also { arg ->
        print(String.format(format, "also", arg, this, result))
        result
    }
    println(String.format("%-10s", result2))*/

    // run
    // this : context
    val result3 = str.run {
        print(String.format(format, "run", "N/A", this, result))
        result
    }
    println(String.format("%-10s", result3))

    // apply
    // this : context
    val result4 = str.apply {
        println(this)
        print(String.format(format, "apply", "N/A", this, result))
        result
    }
    println(String.format("%-10s", result4))
}