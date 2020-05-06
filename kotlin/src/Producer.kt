import java.util.concurrent.Callable
import java.util.concurrent.atomic.AtomicInteger

class Producer(
    private val stack: Stack<Int>,
    private val running : AtomicInteger,
    private val values : Int
) : Callable<Int> {
    override fun call() : Int {
        for (i in 0 until values)
            stack.push(1)
        running.decrementAndGet()
        return 0
    }
}