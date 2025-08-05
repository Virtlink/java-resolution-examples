@file:Suppress("warnings", "PackageDirectoryMismatch", "MayBeConstant", "unused", "UnusedImport", "SortModifiers",
    "SortModifiers", "RedundantSemicolon"
)
package complex3

import imported.x // 16

val x: Int = 17

class Outer : OuterParent() {
    override val x: Int = 0
    companion object {
        open val x: Int = 13
    }
    class Nested : NestedParent() {
        override val x: Int = 7
        companion object {
            open val x: Int = 10
        }
        inner class Inner : InnerParent() {
            override val x: Int = 1
            companion object {
                open val x: Int = 4
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
        }
    }
}



open class OuterParent : OuterBase() {
    override val x: Int = 0
    companion object {
        open val x: Int = 14
    }
    open class NestedParent : NestedBase() {
        override val x: Int = 8
        companion object {
            open val x: Int = 11
        }
        open inner class InnerParent : InnerBase() {
            override val x: Int = 2
            companion object {
                open val x: Int = 5
            }
        }
    }
}



open class OuterBase {
    open val x: Int = 0
    companion object {
        open val x: Int = 15
    }
}
open class NestedBase {
    open val x: Int = 9
    companion object {
        open val x: Int = 12
    }
}
open class InnerBase {
    open val x: Int = 3
    companion object {
        open val x: Int = 6
    }
}


