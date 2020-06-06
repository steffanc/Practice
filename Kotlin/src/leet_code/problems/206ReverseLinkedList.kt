package leet_code.problems

import leet_code.ListNode

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return head
    var previous = head
    var current = head.next
    while (current != null) {
        val temp = current.next
        current.next = previous
        previous = current
        current = temp
    }
    head.next = null
    return previous
}

// 1 -> 2 -> null
fun reverseList2(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val node = reverseList2(head.next)
    head.next?.next = head
    head.next = null
    return node
}

fun main() {
    println(reverseList2(ListNode(1).also { it.next = ListNode(2).also { it.next = ListNode(3) } }))
}