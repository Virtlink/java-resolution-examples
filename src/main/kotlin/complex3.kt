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
            val test = x
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


