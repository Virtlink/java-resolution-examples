@file:Suppress("warnings", "PackageDirectoryMismatch", "MayBeConstant", "unused", "UnusedImport")
package open_override

open class A() : Any() {
    open val x: Int = 2
}

open class B(
    open val y: Int = 1,
) : A() {
    open override val x: Int = 3
    open inner class C(): B() {
        open override val y: Int = 5
    }
    companion object {
        open val x: Int = 4
    }
}