package com.kbh.study.generic

/*
* generic을 함수에 적용해서 사용해보자
* */
fun <T : Bell> shake(bell: T) {
    bell.shout()
}