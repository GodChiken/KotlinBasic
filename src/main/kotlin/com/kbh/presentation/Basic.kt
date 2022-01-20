package com.kbh.presentation

data class Employee(
    val name: String,
    val email: String,
    val company: String
) // + automatically generated equals(), hashCode(), toString(), and copy()

object IctusCompany {
    const val companyName: String = "Ictus"
    var managerName = ""
    var peopleCount = 1
    fun call() = "전화 받았습니다."
} // A singleton

fun main() {
    // No `new` keyword

    val employee =
        Employee("김보훈",
        "godchiken@ictus.app",
            IctusCompany.companyName)

    println(employee)

    val ictusDeveloperCompany = IctusCompany
    val ictusDesignerCompany = IctusCompany

    ictusDeveloperCompany.peopleCount += 99

    //ictusDeveloperCompany.companyName += "아이씨티어스 개발회사"
    //ictusDesignerCompany.companyName += "아이씨티어스 디자이너회사"

    ictusDeveloperCompany.managerName = "김보훈"
    ictusDesignerCompany.managerName = "황경화"

    println(ictusDeveloperCompany.peopleCount)
    println(ictusDesignerCompany.peopleCount)
} // Function at the top level