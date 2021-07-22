package com.kbh.study.generic

fun main() {
    KotlinGeneric(Bell()).shake()
    KotlinGeneric(RedBell()).shake()
    KotlinGeneric(BlackBell()).shake()

    shake(Bell());
    shake(RedBell());
    shake(BlackBell());
}
class KotlinGeneric<T : Bell> (val bell: T){
    fun shake(){
        bell.shout()
    }
}