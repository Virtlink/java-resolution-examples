package ambiguity2

interface E
interface D : E

interface C
interface B : C, D
interface A : B


fun f(c: C): Int = 2
fun f(e: E): Int = 3
//fun f(b: B): Int = 4

val test1 = f(object: A {})
val test2 = f(object: B {})
