@file:Suppress("warnings", "PackageDirectoryMismatch", "MayBeConstant", "unused", "UnusedImport")
package xs

open class Foo(
    open val x: Int,
) : Any() {
    companion object {
        open val x: Int = 10
    }
    open fun bar(x: Int): Int = this.x + Foo.x + x
}
