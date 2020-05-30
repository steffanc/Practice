package leet_code.problems

import leet_code.ListNode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    return doAddTwoNumbers(l1, l2, false)
}

fun doAddTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Boolean): ListNode? {
    if (l1 == null && l2 == null) {
        return if (carry) ListNode(1) else null
    }

    var sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + if (carry) 1 else 0
    val newCarry = sum >= 10
    sum %= 10

    val newNode = ListNode(sum)
    newNode.next = doAddTwoNumbers(l1?.next, l2?.next, newCarry)
    return newNode
}

fun main(args: Array<String>) {
    val l1 = ListNode(2).also {
        it.next = ListNode(4)
            .also { it.next = ListNode(3) }
    }
    val l2 = ListNode(9).also {
        it.next = ListNode(9)
            .also { it.next = ListNode(9) }
    }
    val answer = addTwoNumbers(l1, l2)
    println(answer)
}
