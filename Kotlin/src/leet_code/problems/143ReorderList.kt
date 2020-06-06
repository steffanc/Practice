package leet_code.problems

import leet_code.ListNode

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * O(n), O(1)
 */
fun reorderList(head: ListNode?): ListNode? {
    if (head == null) return head

    val length = getLength(head)
    if (length == 1) return head

    val midNode = splitList(head, length)
    val reversedList = reverseList(midNode)
    return mergeLists(head, reversedList)
}

fun getLength(node: ListNode): Int {
    var length = 0
    var n: ListNode? = node
    while (n != null) {
        n = n.next
        length++
    }
    return length
}

//1 -> 2
//1 -> 2 -> 3
fun splitList(node: ListNode, length: Int): ListNode {
    var i = 0
    val mid = (length - 1) / 2
    var previous: ListNode
    var current = node
    while (i <= mid) {
        previous = current
        current = current.next!!
        if (i == mid) {
            previous.next = null
        }
        i++
    }
    return current
}

fun reverseList(node: ListNode): ListNode {
    var previous = node
    var current = node.next
    while (current != null) {
        val temp = current.next
        current.next = previous
        previous = current
        current = temp
    }
    node.next = null
    return previous
}

fun mergeLists(node1: ListNode, node2: ListNode): ListNode {
    var current1: ListNode? = node1
    var current2: ListNode? = node2
    while (current1 != null || current2 != null) {
        val temp1 = current1?.next
        val temp2 = current2?.next
        current1?.next = current2
        current2?.next = temp1
        current1 = temp1
        current2 = temp2
    }
    return node1
}

fun main() {
    println(
        reorderList(
            ListNode(1).also {
                it.next = ListNode(2).also {
                    it.next = ListNode(3).also {
                        it.next = ListNode(4).also {
                            it.next = ListNode(5).also {
                                it.next = ListNode(6)
                            }
                        }
                    }
                }
            })
    )
}
