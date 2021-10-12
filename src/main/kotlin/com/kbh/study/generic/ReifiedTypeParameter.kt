package com.kbh.study.generic


/**
 * 자바에서 제네릭을 사용할 때 Class<T>를 함수에 파라미터로 전달해야하는 경우가 있다.
 * 이러한 경우는 제네릭 함수에서 특정타입이 필요하나 자바의 타입 이레이저 때문에 타입정보를 잃어버리는 경우 필수적으로 따라온다.
 *
 * 코틀린에서는 구체화된 타입파라미터(Reified Type Parameters)를 사용해서 이러한 점을 제거한다.
 *
 * 가령 다양한 타입의 인스턴스 중 특정한 타입의 첫번째 인스턴스를 찾아야하는 경우 기존 자바 스타일의 코드와 차이점을 학습한다.
 * */

abstract class Book(val name: String)
class Fiction(name: String) : Book(name)
class NonFiction(name: String) : Book(name)

val bookList: List<Book> = listOf(Fiction("Moby Dick"), NonFiction("Learn to Code"), Fiction("LOTR"))


// refactoring 전 코드
fun <T> findFirst(bookList: List<Book>, ofClass: Class<T>): T {
    val selected = bookList.filter { book -> ofClass.isInstance(book) }
    if (selected.isEmpty()) {
        throw RuntimeException("not found")
    }
    return ofClass.cast(selected[0])
}

// refactoring 후 코드
/**
 * T 타입을 reified 로 선언하여 Class<T>를 제거한다. 이렇게하면 함수안에서 T를 타입체크와 캐스팅용으로 사용이 가능하다.
 * 또한 reified는 inline 함수로 사용이 가능하다 그래야 파라미터 타입을 사용할 수 있다. 일반적으로 코드가 호출되면 해당 호출된 함수로 분기되어 동작하지만
 * inline 함수는 최종 컴파일된 코드에서 함수를 호출하는 위치에 함수의 본문이 삽입되어 호출한 함수에서 작성한 것과 동일하게 작동하여
 * 성능상 이점을 얻는 방법이다. 그래서 코드가 확장될 때 T는 컴파일시간에 확인되는 실제 타입으로 대체된다.
 *
 * reified로 작성된 함수는 사용하는 입장에서도 이점은 타입 정보를 추가적인 클래스 정보를 아규먼트로 보낼필요가 없다.
 * 또한 캐스팅을 안전하게하고 컴파일 시간 안정성을 확보하여 리턴타입을 커스텀할 수 있다.
 *
 * */
inline fun <reified T> findFirst(bookList: List<Book>): T {
    val selected = bookList.filter { book -> book is T }
    if (selected.isEmpty()) {
        throw RuntimeException("not found")
    }
    return selected[0] as T
}


fun main() {
    // refactoring 전 코드
    println(findFirst(bookList, NonFiction::class.java).name)
    // refactoring 후 코드
    println(findFirst<NonFiction>(bookList).name)
}