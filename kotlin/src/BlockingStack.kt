import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class BlockingStack<T> : Stack<T> {

    private val stack = UnsafeStack<T>()
    private val lock = ReentrantLock()

    override fun push(ele: T) {
        lock.withLock { stack.push(ele) }
    }

    override fun pop() =
        lock.withLock { stack.pop() }
}









