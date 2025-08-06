@file:Suppress("warnings", "PackageDirectoryMismatch", "MayBeConstant", "unused", "UnusedImport", "SortModifiers",
    "SortModifiers", "RedundantSemicolon"
)
package complex3

import imported.x // 16
import imported.y // 18

val x: Int = 17
fun y(a: Int): Int = 17
fun y(a: String): Int = 17

class Outer : OuterParent() {
    override val x: Int = 0
    override open fun y(a: Int) : Int = 0
    override open fun y(a: String) : Int = 0
    companion object {
        open val x: Int = 13
        open fun y(a: Int) : Int = 13
        open fun y(a: String) : Int = 13
    }
    class Nested : NestedParent() {
        override val x: Int = 7
        override open fun y(a: Int) : Int = 7
        override open fun y(a: String) : Int = 7
        companion object {
            open val x: Int = 10
            open fun y(a: Int) : Int = 10
            open fun y(a: String) : Int = 10
        }
        inner class Inner : InnerParent() {
            override val x: Int = 1
            override open fun y(a: Int) : Int = 1
            override open fun y(a: String) : Int = 1
            companion object {
                open val x: Int = 4
                open fun y(a: Int) : Int = 4
                open fun y(a: String) : Int = 4
            }
            val test01 = x                      // 1 ... 17
            val test02 = this.x                 // 1, 2, 3
            val test03 = this@Nested.x          // 7, 8, 9
            val test04 = super.x                // 2, 3
            val test05 = super@Nested.x         // 8, 9
            val test06 = Inner.x                // 4
            val test07 = Nested.x               // 10
            val test08 = Outer.x                // 13
            val test09 = InnerParent.x          // 5
            val test10 = NestedParent.x         // 11
            val test11 = OuterParent.x          // 14
            val test12 = InnerBase.x            // 6
            val test13 = NestedBase.x           // 12
            val test14 = OuterBase.x            // 15

            val yTest01 = y(0)                  // 1 ... 17
            val yTest02 = this.y(0)             // 1, 2, 3
            val yTest03 = this@Nested.y(0)      // 7, 8, 9
            val yTest04 = super.y(0)            // 2, 3
            val yTest05 = super@Nested.y(0)     // 8, 9
            val yTest06 = Inner.y(0)            // 4
            val yTest07 = Nested.y(0)           // 10
            val yTest08 = Outer.y(0)            // 13
            val yTest09 = InnerParent.y(0)      // 5
            val yTest10 = NestedParent.y(0)     // 11
            val yTest11 = OuterParent.y(0)      // 14
            val yTest12 = InnerBase.y(0)        // 6
            val yTest13 = NestedBase.y(0)       // 12
            val yTest14 = OuterBase.y(0)        // 15

//            val yrefTest01: (Int) -> Int = ::y                  // 1 ... 17
//            val yrefTest02: (Int) -> Int = this::y             // 1, 2, 3
//            val yrefTest03: (Int) -> Int = this@Nested::y      // 7, 8, 9
//            val yrefTest06: (Int) -> Int = Inner::y            // 4
//            val yrefTest07: (Int) -> Int = Nested::y           // 10
//            val yrefTest08: (Int) -> Int = Outer::y            // 13
//            val yrefTest09: (Int) -> Int = InnerParent::y      // 5
//            val yrefTest10: (Int) -> Int = NestedParent::y     // 11
//            val yrefTest11: (Int) -> Int = OuterParent::y      // 14
//            val yrefTest12: (Int) -> Int = InnerBase::y        // 6
//            val yrefTest13: (Int) -> Int = NestedBase::y       // 12
//            val yrefTest14: (Int) -> Int = OuterBase::y        // 15
        }
    }
}



open class OuterParent : OuterBase() {
    override val x: Int = 0
    override open fun y(a: Int) : Int = 0
    override open fun y(a: String) : Int = 0
    companion object {
        open val x: Int = 14
        open fun y(a: Int) : Int = 14
        open fun y(a: String) : Int = 14
    }
    open class NestedParent : NestedBase() {
        override val x: Int = 8
        override open fun y(a: Int) : Int = 0
        override open fun y(a: String) : Int = 0
        companion object {
            open val x: Int = 11
            open fun y(a: Int) : Int = 11
            open fun y(a: String) : Int = 11
        }
        open inner class InnerParent : InnerBase() {
            override val x: Int = 2
            override open fun y(a: Int) : Int = 2
            override open fun y(a: String) : Int = 2
            companion object {
                open val x: Int = 5
                open fun y(a: Int) : Int = 5
                open fun y(a: String) : Int = 5
            }
        }
    }
}



open class OuterBase {
    open val x: Int = 0
    open fun y(a: Int) : Int = 0
    open fun y(a: String) : Int = 0
    companion object {
        open val x: Int = 15
        open fun y(a: Int) : Int = 15
        open fun y(a: String) : Int = 15
    }
}
open class NestedBase {
    open val x: Int = 9
    open fun y(a: Int) : Int = 9
    open fun y(a: String) : Int = 9
    companion object {
        open val x: Int = 12
        open fun y(a: Int) : Int = 12
        open fun y(a: String) : Int = 12
    }
}
open class InnerBase {
    open val x: Int = 3
    open fun y(a: Int) : Int = 3
    open fun y(a: String) : Int = 3
    companion object {
        open val x: Int = 6
        open fun y(a: Int) : Int = 6
        open fun y(a: String) : Int = 6
    }
}


