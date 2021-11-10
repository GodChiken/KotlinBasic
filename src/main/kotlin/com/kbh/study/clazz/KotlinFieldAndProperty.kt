package com.kbh.study.clazz

/**
 * 코틀린에서 필드는 없다.
 * Car의 yearOfMake를 호출하면 실제로는 getYearOfMake()를 호출하게된다.
 *
 * 각각의 클래스를 별도의 파일로 만들어 다음과 같은 명령어로 테스트해보자
 *
 * - kotlinc-jvm Car.kt
 * - javap -p Car.class
 *
 * - kotlinc-jvm Car.kt UseCar.kt
 * - javap -p UseCarKt.class
 *
 *
 * */
class Car(val yearOfMake: Int, var color: String)

/**
 * 컴파일 결과 요약분
 * 2개의 백킹필드, 2개의 getter, 1개의 setter, 생성자
 * */
//public final class com.kbh.study.class.Car {
//    private final int yearOfMake;
//    private final java.lang.String color;
//    public com.kbh.study.class.Car(int, java.lang.String);
//    public final int getYearOfMake();
//    public final java.lang.String getColor();
//}

/*
* 아래 컴파일결과를 보면 필드에 직접 접근하는 것이 아닌 setter, getter를 활용하는 모습을 확인할 수있다.
* */
/*public final class com.kbh.study.class.UseCarKt {
    public static final kotlin.Pair<java.lang.Integer, java.lang.String> useCarObject();
    Code:
    0: new           #10                 // class com/kbh/study/class/Car
    3: dup
    4: sipush        2021
    7: ldc           #12                 // String Bo
    9: invokespecial #16                 // Method com/kbh/study/class/Car."<init>":(ILjava/lang/String;)V
    12: astore_0
    13: aload_0
    14: invokevirtual #20                 // Method com/kbh/study/class/Car.getYearOfMake:()I
    17: istore_1
    18: aload_0
    19: ldc           #22                 // String Green
    21: invokevirtual #26                 // Method com/kbh/study/class/Car.setColor:(Ljava/lang/String;)V
    24: aload_0
    25: invokevirtual #30                 // Method com/kbh/study/class/Car.getColor:()Ljava/lang/String;
    28: astore_2
    29: iload_1
    30: invokestatic  #36                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
    33: aload_2
    34: invokestatic  #42                 // Method kotlin/TuplesKt.to:(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;
    37: areturn
}*/
fun useCarObject(): Pair<Int, String> {
    val car = Car(2021, "Bo")
    val year = car.yearOfMake
    car.color = "Green"
    val color = car.color
    return year to color
}

/**
 * Car 클래스에서 변경되어 실습하는 클래스이다.
 * 커스텀 getter,setter를 가진 필드를 정의하고 field 키워드를 사용하지 않는다면 백킹필드가 생성되지 않는다.
 * yearOfMake는 프로퍼티이며, theColor는 필드가 아닌 파라미터다. 파라미터에 var, val를 사용하지 않는다.
 * 파라미터 theColor은 프로퍼티 color과 이름을 동일하게 하여 java에서의 this.color = color 느낌으로 가져갈 수 있으나 혼란을 줄 수 있다는
 * 저자의 말도 있기에 실제 코드컨벤션을 정해서 사용시에는 충분한 논의를 하는게 좋을것 같다.
 *
 * 충분히 비어있는지 검증하는 코드 이후 field에 의해 참조되고 있는 필드에 할당한다.
 *
 * */
class HaveNameCar(val yearOfMake: Int, theColor: String) {
    var fuelLevel = 100
    var color = theColor
        set(value) {
            if (value.isBlank()) {
                throw RuntimeException("no empty")
            }
            field = value
        }
}
/*
* HaveNameCar 를 자바로 변환한다면 다음과 같다.
* intellij action -> Show Kotlin Bytecode -> decompile 로 확인한다.
* 즉 멤버변수이냐, 생성자의 파라미터이냐 차이로 이해하자
* */
/*
public final class HaveNameCar {
    private int fuelLevel;
    @NotNull
    private String color;
    private final int yearOfMake;

    public final int getFuelLevel() {
        return this.fuelLevel;
    }

    public final void setFuelLevel(int var1) {
        this.fuelLevel = var1;
    }

    @NotNull
    public final String getColor() {
        return this.color;
    }

    public final void setColor(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank((CharSequence)value)) {
            throw (Throwable)(new RuntimeException("no empty"));
        } else {
            this.color = value;
        }
    }

    public final int getYearOfMake() {
        return this.yearOfMake;
    }

    public HaveNameCar(int yearOfMake, @NotNull String theColor) {
        Intrinsics.checkNotNullParameter(theColor, "theColor");
        super();
        this.yearOfMake = yearOfMake;
        this.fuelLevel = 100;
        this.color = theColor;
    }
}*/

/**
 * 백킹 프로퍼티 (Backing Property)
 * 백킹 필드를 사용하면 getter 및 setter 범위에서만 속성 필드에 액세스할 수 있다.
 * 그러나 백킹 필드 기능이 적용되지 않는 경우나 getter 또는 setter를 사용하지 않고 직접 필드에 액세스하려면 백킹 프로퍼티을 사용해야 한다.
*/

private var _table: Map<String, Int>? = null
val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // Type parameters are inferred
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }

fun main() {
    val haveNameCar = HaveNameCar(2021, "Bo")
    haveNameCar.color = "Green"
    haveNameCar.fuelLevel--
    println(haveNameCar.fuelLevel)
    try {
        haveNameCar.color = ""
    } catch (ex: Exception) {
        println(ex.message)
    }
    println(haveNameCar.color)
}