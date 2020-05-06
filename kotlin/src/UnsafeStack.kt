
class UnsafeStack<T> : Stack<T> {

    class Node<T>(val ele : T) {
        var next : Node<T>? = null
    }

    private var head : Node<T>? = null

    override fun push(ele: T) {
        val newHead = Node(ele)
        if (head != null) {
            newHead.next = head
        }
        head = newHead
    }

    override fun pop(): T? {
        if (head == null) return null
        val oldHead = head
        val newHead = oldHead?.next
        head = newHead
        return oldHead?.ele
    }
}












