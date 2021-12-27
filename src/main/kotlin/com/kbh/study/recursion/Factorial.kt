package com.kbh.study.recursion

import java.math.BigInteger

/**
 * 꼬리재귀의 컴파일 내용을 확인하게되면
 * "invokevirtual" 명령어를 사용해서 factorialRec() 재귀적으로 호출을 했다.
 * 이후 BigInteger에 multiply() 메소드가 호출되므로써 재귀프로시저가 재귀 프로세스로 컴파일 되는 것을 보여준다.
 *
 * 그러나 재귀에서 재귀적으로 호출이 이루어지지 않았다.
 * 대신 ifgt를 호출하고 goto로 함수의 다른 부분으로 점프한다.
 * 즉 재귀 프로시저가 반복을 이용하는 프로세스로 컴파일 됬다.
 *
 * 꼬리호출 최적화는 재귀를 반복으로 변환해서 스택 레벨의 숫자를 제어한다.
 * */

object Factorial {
    fun factorialRec(n: Int): BigInteger =
        if (n <= 0) 1.toBigInteger() else n.toBigInteger() * factorialRec(n - 1)
    tailrec fun factorial(n: Int,
                          result: BigInteger = 1.toBigInteger()): BigInteger =
        if (n <= 0) result else factorial(n - 1, result * n.toBigInteger())
}

//javap -c -p Factorial.class
//Compiled from "Factorial.kt"
/*
public final class com.kbh.study.recursion.Factorial {
    public static final com.kbh.study.recursion.Factorial INSTANCE;

    private com.kbh.study.recursion.Factorial();
    Code:
    .....

    // 재귀
    public final java.math.BigInteger factorialRec(int);
    Code:
    ...
    42: invokevirtual #29                 // Method factorialRec:(I)Ljava/math/BigInteger;
    ...
    54: dup
    55: ldc           #35                 // String this.multiply(other)
    57: invokestatic  #27                 // Method kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V

    // 꼬리재귀
    public final java.math.BigInteger factorial(int, java.math.BigInteger);
    Code:
    ...
    27: ifgt          35
    30: aload         8
    32: goto          90
    ...
    76: invokevirtual #33                 // Method java/math/BigInteger.multiply:(Ljava/math/BigInteger;)Ljava/math/BigInteger;
    79: dup
    80: ldc           #35                 // String this.multiply(other)
    82: invokestatic  #27                 // Method kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
    85: astore        5
    87: goto          14
    90: areturn
}*/
