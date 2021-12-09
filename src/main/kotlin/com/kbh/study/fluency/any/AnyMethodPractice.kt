package com.kbh.study.fluency.any

/**
 * 단순히 인자값을 받아 StringBuilder에 축적하는 예제
 * */
class Mailer{
    var details = StringBuilder()
    fun from(addr: String) = details.append("from $addr...\n")
    fun to(addr: String) = details.append("to $addr...\n")
    fun subject(line: String) = details.append("subject $line \n")
    fun body(message: String) = details.append("body $message \n")
    fun send() = "...sending...\n$details"
}

fun createMailer() = Mailer()

fun prepareAndSend(mailer: Mailer) = mailer.run {
    from("from@naver.com")
    to("to@naver.com")
    subject("Your code Fuck")
    body("...details...")
    send()
}

fun prepareMailer(mailer: Mailer):Unit {
    mailer.run {
        from("from@naver.com")
        to("to@naver.com")
        subject("Your code Fuck")
        body("...details...")
        send()
    }
}

fun sendMail(mailer: Mailer): Unit {
    mailer.send()
    println("Mail sent")
}

fun main() {
    val mailer = Mailer()

    mailer.from("from@naver.com")
    mailer.to("to@naver.com")
    mailer.subject("Your code Fuck")
    mailer.body("...details...")
    val result = mailer.send()
    println(result)

    /**
     * apply 를 통한 반복 참조 제거
     * 불필요한 참조를 제거할 수 있으며, 작성된 클래스에서 인스턴스를 리턴하는 메소드는 존재하지 않고 디자인되어있지도 않다.
     * 그러나 apply() 는 해당 해당 인스턴스에서 호출하고 같은 인스턴스를 반환하므로 메서드 체이닝이 가능하다.
     * 이렇게 적으면 사실 적으나 마나하므로, apply()는 마지막으로 호출한 객체의 컨텍스트에서 람다를 실행하는 점을 이용해서 좀 더 축약이가능하다.
     * */
    val applyMailer = Mailer()
        .apply { from("from@naver.com") }
        .apply { to("to@naver.com") }
        .apply { subject("Your code Fuck") }
        .apply { body("...details...") }
    println(applyMailer.send())


    val applyMailer2 = Mailer().apply {
            from("from@naver.com")
            to("to@naver.com")
            subject("Your code Fuck")
            body("...details...")
        }
    println(applyMailer2.send())

    /**
     * run 을 활용한 결과까지 한번에 얻기
     * 주요용도는 학습했다시피 run()은 람다의 결과를 리턴한다. 또한 대상이 되는 인스턴스를 더이상 쓰지 않는경우 활용한다.
     *
     * 연속적으로 호출하고 추후에도 활용될 여지가 있다면 apply()를 활용하며,
     * 마지막으로 람다표현식의 결과를 유지하고 더이상 사용하지 않는경우 run()을 활용한다.
     *
     * 둘다 타깃 객체에의 컨텍스트에서 사용하고 싶은경우에만 사용해야한다.
     * */
    val sendMailer = Mailer().run {
        from("from@naver.com")
        to("to@naver.com")
        subject("Your code Fuck")
        body("...details...")
        send()
    }
    println(sendMailer)

    /**
     * let 을 이용한 객체를 인자로 넘기기
     *
     * 함수에서 인스턴스를 받았지만 해당 인스턴스를 다른 메소드의 인자로 전달하고 싶은경우 매끄럽지 못한 경우가 많다.
     * 이런 경우는 굉장히 허다하다.
     *
     * 아규먼트로 전달된 람다의 결과를 사용하기 원한다면 let()은 좋은 방법이 된다.
     * 그러나 let()을 호출한 타깃 객체에 지속적인 작업이 필요한 경우 also()를 활용한다.
     * */
    val mailerByCreateMailer = createMailer()
    val resultByPrepareAndSend = prepareAndSend(mailerByCreateMailer)
    println(resultByPrepareAndSend)

    var letMailer = createMailer().let { letMailerElement -> prepareAndSend(letMailerElement) }
    letMailer = createMailer().let { prepareAndSend(it) }
    letMailer = createMailer().let(::prepareAndSend)

    println(letMailer)

    /**
     * also 를 사용한 void 함수 체이닝
     *
     * void 함수(Unit return)는 일반적으로 메서드 체이닝이 불가하나 also()를 활용한다면 가능하다.
     * 타깃 객체를 람다에 파라미터로 전달하고 람다의 리턴을 무시한 후 다시 호출한 곳으로 리턴하기 때문에 조금 더 자연스러운 코드가 가능하다.
     * */
    val alsoMailer = createMailer()
    prepareMailer(alsoMailer)
    sendMail(mailer)

    createMailer()
        .also (::prepareMailer)
        .also (::sendMail)
}