package leet_code.problems

import java.util.*

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * O(n*log(k)), O(k)
 */
fun findKthLargest(nums: IntArray, k: Int): Int {
    val priority = PriorityQueue<Int>()
    nums.forEach {
        if (priority.size == k) {
            if (it > priority.peek()) {
                priority.remove()
                priority.add(it)
            }
        } else {
            priority.add(it)
        }
    }
    return priority.remove()
}

fun main() {
    println(findKthLargest(arrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6).toIntArray(), 4))
}