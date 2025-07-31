@file:Suppress("warnings", "PackageDirectoryMismatch", "MayBeConstant", "unused", "UnusedImport")
package nested_base_companion_objects

open class ABase() : Any() {
    companion object {
        open val a2: Int = 4
        open val x: Int = 4     // (4)
    }
    open class BBase() : ABase() {
        companion object {
            open val b2: Int = 5
            open val x: Int = 5     // (3)
        }
        open class CBase() : BBase() {
            companion object {
                open val c2: Int = 6
                open val x: Int = 6     // (2)
            }
        }
    }
}
open class A() : ABase() {
    companion object {
        open val a1: Int = 1
        open val x: Int = 1      // (6)
    }
    open class B() : BBase() {
        companion object {
            open val b1: Int = 2
            open val x: Int = 2     // (5)
        }
        open class C() : CBase() {
            companion object {
                open val c1: Int = 3
                open val x: Int = 3     // (1)
                open val test1 = a1 + b1 + c1 + a2 + b2 + c2
                open val test2 = x + A.x + ABase.x + B.x + BBase.x + C.x + CBase.x
            }
        }
    }
}