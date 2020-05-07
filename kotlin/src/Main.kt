import java.text.NumberFormat
import java.util.*
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.ArrayList
import kotlin.system.measureNanoTime

fun main() {

    val operations = 10_000_000
    val producers = 2
    val consumers = 2
    val threads = 2 //Runtime.getRuntime().availableProcessors()

    println()

    println("Producers:  ${producers.form()}")
    println("Consumers:  ${consumers.form()}")
    println("Threads:    $threads")
    println("Operations: ${operations.form()}")

    println()

    println("Test Unsafe Stack")
    testStack(
        producers,
        consumers,
        operations,
        threads,
        UnsafeStack())

    println()

    println("Test Safe Stack (Blocking)")
    testStack(
        producers,
        consumers,
        operations,
        threads,
        BlockingStack())

    println()

    println("Test Safe Stack (Non-blocking)")
    testStack(
        producers,
        consumers,
        operations,
        threads,
        NonblockingStack())
}

private val Formatter = NumberFormat.getNumberInstance(Locale.GERMAN)
private fun Int.form() = Formatter.format(this)

fun testStack(
    producers : Int,
    consumers : Int,
    operations : Int,
    threads : Int,
    stack : Stack<Int>) {

    val callableList = ArrayList<Callable<Int>>()
    val prodCounter = AtomicInteger(producers)

    for (i in 0 until producers)
        callableList.add (Producer(stack, prodCounter, operations / producers))

    for (i in 0 until consumers)
        callableList.add (Consumer(stack, prodCounter))

    val executor = Executors.newFixedThreadPool(threads)

    var results : List<Future<Int>>? = null
    val time = measureNanoTime {
        results = executor.invokeAll(callableList)
        executor.shutdown()
        try { executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (e : InterruptedException) { println("Some error") }
    }

    var sum = 0
    for (future in results!!) {
        try {
            val res = future.get()
            //println("worker result: ${res.form()}")
            sum += res
        } catch (e : InterruptedException) {
            println("Some error")
        }
    }

    println("results:    ${sum.form()}")
    println("errors:     ${(sum -operations).form()}")
    println("duration:   ${time/1_000_000_000.0} seconds")
}