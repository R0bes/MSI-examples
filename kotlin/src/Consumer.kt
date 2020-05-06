import java.util.concurrent.Callable
import java.util.concurrent.atomic.AtomicInteger

class Consumer(
    private val stack: Stack<Int>,
    private val running : AtomicInteger
) : Callable<Int> {
    override fun call(): Int {
        var sum = 0;
        while(running.get() > 0) {
            val got = stack.pop()
            if(got != null) sum += got
        }
        do {
            val got = stack.pop()
            if(got != null) sum += got
        } while(got != null)
        return sum
    }
}