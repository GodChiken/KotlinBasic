package com.kbh.study.`class`.advanced


/**
 * 최근 자바에서의 인터페이스는 과거와 달리 많이 달라졌다.
 * 메서드의 명세만 할수있었던 과거와 달리 default, private, static 등의 메서드를 활용이 가능해지며 이것을 통애 해당 인터페이스의 점진적인 확장을
 * 고려해 볼 수도 있다.
 *
 * 코틀린은 비교적 자바의 변화에 맞춰나가는 언어이기때문에 코틀린에서의 인터페이스는 이러한 자바의 변경점에 대해서 어떻게 대응하고 있는지 알아보자.
 *
 * default 키워드 없이 인터페이스 내부에 매서드를 구현이 가능하다.
 * static 키워드는 직접적으로 사용이 불가하나 companion object를 활용하여 이를 대체한다.
 * doubleUP()같은 경우에는 오버라이드를 선택적으로 가능하다.
 * */

interface Remote {
    fun up()
    fun down()
    fun doubleUp() {
        up()
        up()
    }

    companion object {
        fun combine(first: Remote, second: Remote): Remote = object : Remote {
            override fun up() {
                first.up()
                second.up()
            }

            override fun down() {
                first.down()
                second.down()
            }
        }
    }
}

/*
class TV {
    var volume = 0
}

class TVRemote(val tv: TV) : Remote {
    override fun up() {
        tv.volume++
    }

    override fun down() {
        tv.volume--
    }
}
*/

class TV {
    private var volume = 0
    val remote: Remote
    /* 이 속성은 매번 호출시 마다 새로운 인스턴스를 리턴하도록 디자인 되어있다.*/
    get() = TVRemote()

    override fun toString(): String {
        return "Volumne : ${volume}"
    }
    inner class TVRemote : Remote {
        override fun up() {
            volume++
        }

        override fun down() {
            volume--
        }
        // this : TVRemote, this@TV : TVRemote 클래스인 외부 클래스 TV
        // super@TV : 더 상위에 외부 클래스(Any) 에 접근하고 싶은경우는 사용하나 자주하면 다형성과 메서드 오버라이드의 의도를 해치게 된다.
        override fun toString(): String {
            return "Remote : ${this@TV.toString()}"
        }
    }
}

fun main() {
    val tv = TV()
    val remote = tv.remote
    println("$tv")
    remote.up()
    println("After increasing : $tv")
    remote.doubleUp()
    println("After doubleUp : $tv")
}

