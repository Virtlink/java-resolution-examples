@file:Suppress("warnings", "PackageDirectoryMismatch", "MayBeConstant", "unused", "UnusedImport", "SortModifiers",
    "SortModifiers"
)
package inner_classes

open class ABase() : Any() {
    open val a2: Int = 4
    open val x: Int = 4         // (6)
}
open class BBase() : Any() {
    open val b2: Int = 5
    open val x: Int = 5     // (4)
}
open class CBase() : Any() {
    open val c2: Int = 6
    open val x: Int = 6     // (2)
}
open class A() : ABase() {
    open val a1: Int = 1
    override open val x: Int = 1        // (5)
    inner open class B() : BBase() {
        open val b1: Int = 2
        override open val x: Int = 2    // (3)
        inner open class C() : CBase() {
            open val c1: Int = 3
            override open val x: Int = 3     // (1)
            open val test1 = a1 + b1 + c1 + a2 + b2 + c2
            open val test2 = x + this@A.x + super@A.x + this@B.x + super@B.x + this.x + super@C.x
        }
    }
}