package leet_code.phone_interview.random.three

import leet_code.ListNode

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 *
 * Example 2:
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
fun oddEvenList(head: ListNode?): ListNode? {
    var current = head
    var oddHead: ListNode? = null
    var evenHead: ListNode? = null
    var currentOdd: ListNode? = null
    var currentEven: ListNode? = null
    var isOdd = true
    while (current != null) {
        val next = current.next
        if (isOdd) {
            if (oddHead == null) {
                oddHead = current
                currentOdd = current
            } else {
                currentOdd?.next = current
                currentOdd = current
            }
        } else {
            if (evenHead == null) {
                evenHead = current
                currentEven = current
            } else {
                currentEven?.next = current
                currentEven = current
            }
        }
        current = next
        isOdd = !isOdd
    }
    currentEven?.next = null
    currentOdd?.next = evenHead
    return oddHead
}

fun main() {
    println(oddEvenList(ListNode(1).also { it.next = ListNode(2).also { it.next = ListNode(3) } }))
}