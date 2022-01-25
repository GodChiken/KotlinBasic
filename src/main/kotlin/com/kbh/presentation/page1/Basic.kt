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
} // Function at the top level