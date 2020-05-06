import java.util.concurrent.atomic.AtomicReference

class NonblockingStack<T> : Stack<T>{

    class Node<T>(val ele : T) {
        var next : Node<T>? = null
    }

    private val head : AtomicReference<Node<T>?> = AtomicReference()

    override fun push(ele : T) {
        val newHead = Node(ele)
        do {
            val oldHead = head.get()
            newHead.next = oldHead
        } while(!head.compareAndSet(oldHead, newHead))
    }

    override fun pop() : T? {
        var oldHead : Node<T>
        do {
            oldHead = head.get() ?: return null
            val newHead = oldHead.next
        } while(!head.compareAndSet(oldHead, newHead))
        return oldHead.ele
    }
}








