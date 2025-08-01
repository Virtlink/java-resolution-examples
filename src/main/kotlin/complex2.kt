@file:Suppress("warnings", "PackageDirectoryMismatch", "MayBeConstant", "unused", "UnusedImport", "SortModifiers",
    "SortModifiers", "RedundantSemicolon"
)
package complex2

open class ABase {
    open val x: Int = 3             // (3)
    companion object {
        open val x: Int = 5         // (5)
    }
    open class BBase() : ABase() {
        override open val x: Int = 2        // (2)
        companion object {
            open val x: Int = 4         // (4)
        }
    }
}

class A() : ABase() {
    override val x: Int = 6             // (6)
    companion object {
        val x: Int = 7                 // (7)
    }
    inner class B() : BBase() {
        override val x: Int = 1         // (1)
        val test = x
    }
}