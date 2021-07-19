// 코틀린은 고전적인 언어들과 차이점은 변수의 초기화가 이루어 지지 않은경우
// 해당 변수의 기본값 혹은 null 로 초기화되지만, 기본적으로 null 을 허용하지 않으며 syntax error가 발생한다.
// 이로서 컴파일을 애초에 방지하므로 의도치않은 동작(ex)NPE)을 방지하고 Java보다 조금 더 null safe 하다는 점이 마음에 들었다.
class VariablesAndDataTypes {
    // 선언 및 초기화, 모든 상황에서 읽고 쓰기가 가능하다.
    var i:Int = 100
    // 선언시 초기화는 가능하나, 이후 변경은 불가능하다.
    // 런타임시 변경되지 말아야할 것들을 활용해볼 필요가 있다.
    val j:Int = 300
    // nullable 을 사용하는 문법이다. null을 허용해야하는 경우를 고려해야 한다면 사용한다.
    var k:Int? = 100
    //코틀린은 8진수의 표기법은 지원하지 않는다.
    var integerTypeByByte:Byte = 100
    var integerTypeShort:Short = 100
    var integerTypeLong:Long = 100L
    var integerTypeByHex:Int = 0x100
    var integerTypeByBinary:Int = 0b10101

    var realNumberTypeByFloat:Float = 100f
    var realNumberTypeByDouble:Double = 100.0
    //필요 시 지수표기법이 추가 가능하다
    var realNumberTypeByDouble2:Double = 111.1e10
    // 코틀린은 문자열을 내부적으로 UTF-16 BE 인코딩으로 관리함으로서 문자당 2byte를 소유한다.
    var character:Char = '김'
    var string1:String = "godchiken"
    var string2 = "godchiken"
    var multilineString:String = """multiLien
        이 가능한 문법이 생겼다.
    """
}

fun main() {
    val keyword = VariablesAndDataTypes()
    println(keyword.i)
    println(keyword.j)
    println(keyword.k)
    println(keyword.integerTypeByByte)
    println(keyword.integerTypeShort)
    println(keyword.integerTypeLong)
    println(keyword.integerTypeByHex)
    println(keyword.integerTypeByBinary)
    println(keyword.realNumberTypeByFloat)
    println(keyword.realNumberTypeByDouble)
    println(keyword.realNumberTypeByDouble2)
    println(keyword.character)
    println(keyword.string1)
    println(keyword.string2)
    println(keyword.multilineString)
}