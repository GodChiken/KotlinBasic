package com.kbh.presentation.page1

data class Employee(
    val name: String,
    val email: String,
    val company: String
) // + automatically generated equals(), hashCode(), toString(), and copy()

object IctusCompany {
    const val companyName = "Ictus"
    var managerName = ""
    var peopleCount = 1
    fun call() = "전화 받았습니다."
} // A singleton

// 자바와 비교하여 코드량이 확연히 줄어들어 편리해졌다.
// 영어 문장을 기술하듯 작성하는 방식이 마음에 든다.
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
        for (i in 10 downTo 1) {
            println(i)
        }

        val nameList = listOf("A", "B", "C")
        for ((i, name) in nameList.withIndex()) {
            println("$name 은 $i 째 인덱스에 위치합니다.")
        }
    }
}

fun main() {
    // No `new` keyword
    // No `;`
    val employee =
        Employee(name = "김보훈",
        "godchiken@ictus.app",
            IctusCompany.companyName
        )

    println(employee)

    val ictusDeveloperCompany = IctusCompany
    val ictusDesignerCompany = IctusCompany

    IctusCompany.peopleCount += 99

    //ictusDeveloperCompany.companyName += "아이씨티어스 개발회사"
    //ictusDesignerCompany.companyName += "아이씨티어스 디자이너회사"

    IctusCompany.managerName = "김보훈"
    IctusCompany.managerName = "황경화"

    println(IctusCompany.peopleCount)
    println(IctusCompany.peopleCount)

    val loop = Loop()
    loop.forExample()
} // Function at the top level