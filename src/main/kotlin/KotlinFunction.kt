class KotlinFunction {
    fun add(a: Int, b: Int, c: Int): Int {
        return a + b + c
    }
}

// 단일 표현식 함수
// 단일 표현식 함수에서 반환형에 대한 타입값이 추론이 가능하므로 생략이 가능하다.
fun add(a: Int, b: Int, c: Int) = a + b + c

// 함수란 내부적으로 기능을 가진 형태이나, 외부에서 관점으로 보았을 때
// 파라미터를 넣는다고 하는 점 외에는 자료형이 결정된 변수라는 개념으로 접근하는 것이 좋다.
// First Class Citizen 을 다시 한번 살펴보고 가자.
// 모든 요소는 함수의 실제 매개변수가 될 수 있다.
// 모든 요소는 함수의 반환 값이 될 수 있다.
// 모든 요소는 할당 명령문의 대상이 될 수 있다.
// 모든 요소는 동일 비교의 대상이 될 수 있다.
fun main() {
    val kotlinFunction = KotlinFunction()
    print(kotlinFunction.add(1, 2, 3))
    print(add(1,2,3))
}