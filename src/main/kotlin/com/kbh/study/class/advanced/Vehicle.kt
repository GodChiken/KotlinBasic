package com.kbh.study.`class`.advanced

/**
 * 코틀린은 기본적으로 자바와 다르게 클래스 설계자의 의도를 벗어나는 것을 방지해준다.
 * 기본적으로 코틀린의 클래스는 'final'이므로 클래스 설계자가 별도의 조치를 하지 않은한 클래스를 베이스 클래스 활용하는 것은 불가하다.
 * 'open' 키워드로 클래스 설계자는 상속받을 수 있도록 제공해야하며 클래스를 활용하는 자는 override라 명시하여 해당 베이스 클래스의 메소드를 오버라이드한다.
 *
 * 클래스 내부에 정의된 속성과 생성자에 정의된 속성 모두 override 가 가능하다
 *
 * val로 정의된 속성은 val, var를 모두 활용하여 override가 가능하다. 이는 val가 getter만 가지고있고 자식클래스에서 var로 override 하면서 setter
 * 생성이 가능하다.
 *
 * var로 정의된 속성은 오직 var로만 가능하다. 이는 val로 override 하려고하면 setter를 제거할 수 없기 때문이다.
 *
 * */
open class Vehicle(val year: Int, open var color:String){
    open val km = 0
    // 베이스 클래스를 override 했으나, 자식클래스에서 더이상 오버라이드 하지 못하도록 방지했다.
    final override fun toString(): String {
        return "year : $year ::: color : $color ::: km : $km"
    }
    fun repaint(newColor : String){
        color = newColor
    }
}