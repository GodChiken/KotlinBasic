package com.kbh.study.dsl

import java.time.LocalDate

/**
 * 코틀린은 정적 타입언어이다.
 * 정적 타입언어는 호스트 언어를 기반으로 하여 작성되는 내부 DSL에 적합하지않다.
 * 그러나 특별한 기능으로 위와 관련된 한계를 극복했다.
 * */

infix fun String.at(point: Double) = point.toString()
infix fun String.by(point: Double) = point.toString()
infix fun Int.days(ago: LocalDate): LocalDate { return ago.minusDays(this.toLong()) }

/*infix fun String.meeting(function: () -> Unit) {
    println(function())
}*/

fun main() {
    val starts = "";
    val end = "";
    val fuck = "";

    starts.at(14.30);
    end.by(15.20);

    // 코틀린은 세미콜론을 강요하지 않는다.
    starts.at(14.30)
    end.by(15.20)

    //infix를 이용한 점과 괄호제거
    starts at 14.30
    end by 14.30

    //확장함수를 통한 도메인 특화, 기존 클래스에 함수를 인젝팅
    val ago = LocalDate.now()
    2.days(ago)
    //infix 키워드와 함께 사용하면 더욱 자연스운 코드가 얻어진다.
    2 days ago

    //해당 코드를 원할하게 동작하려면 몇가지 구성할게 있으나, 연습차원에서 최대한 참고하지 않고 작성해본다.
    //람다는 가장 마지막 것을 리턴하므로 코드에서 의도하는 결과(start, end 둘다 호출되는 느낌을 준다)는 얻을 수 없었다.
    /*"Release Planning".meeting ({
        starts at 14.30
        end by 15.20
    })
    "Release Planning" meeting {
        starts at 14.30
        end by 15.20
    }*/
}