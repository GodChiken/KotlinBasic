package com.kbh.study.`class`

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