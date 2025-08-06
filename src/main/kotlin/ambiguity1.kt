package ambiguity1

val f: (Int) -> Int = { it + 1 }
fun f(): Int = 1
fun f(a: Int): Int = 2
fun f(a: String): Int = 3

val test = f(2)
