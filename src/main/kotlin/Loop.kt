// 자바와 비교하여 코드량이 확연히 줄어들어 편리해졌다.
// 영어 문장을
class Loop {
    fun forExample() {
        for (i in 0..10) {
            println(i)
        }
        for (i in 0..10 step 3) {
            println(i)
        }
        for (i in 9 downTo 0 step 3) {
            println(i)
        }
        for (i in 'a'..'z') {
            println(i)
        }
    }
}

fun main() {
    val loop = Loop()
    loop.forExample()
}