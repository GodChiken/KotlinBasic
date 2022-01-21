package com.kbh.presentation.page2

fun main() {
    val boHun = BoHun()
    boHun.run()
    boHun.eat()
}

// kotlin 에서 인터페이스는 프로퍼티, 추상함수, 일반함수를 소유할 수 있다.
// 구현부가 존재하는 함수는 open 함수로 간주한다.
// 구현부가 없고 별도의 키워드가 없어도 추상함수로 간주하여 포함된 모든 함수를 구현 및 재정이가 가능하다.
// 여러개의 인터페이스를 상속받는중 같은 이름과 형태의 함수가 존재하는경우 오버라이딩하여 혼선을 방지한다.
interface Runner {
   fun run()
}
interface Eater{
    fun eat(){
        println("먹습니다.")
    }
}
class BoHun : Runner, Eater {
    override fun run() {
        println("뛴다.")
    }
}