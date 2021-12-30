#### 내부 DSL 만들기에 대한 회고

* 저자는 코틀린의 자연스러움, 표현력 등을 어필하면서 타 정적 타입언어와 비교시 호스트 언어로써 특징이 뚜렸하다고 했다.
* DSL을 구성해보는 것을 실습해보면서 타입 안정성이 보장되기 때문에 빠르게 실패지점을 파악할 수 있었다.
* @DslMarker를 통해 스코프의 제한과 암시적리시버에 의한 호출에 의해 발생하는 오류나 오작동을 방지할 수 있어서 좋았다. 