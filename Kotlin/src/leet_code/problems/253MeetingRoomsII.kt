package leet_code.problems

import java.util.*

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 *
 * NOTE: input types have been changed on April 15, 2019.
 * Please reset to default code definition to get new method signature.
 *
 * O(n*log(n) + n*log(n)), O(n)
 */
fun minMeetingRooms(intervals: Array<IntArray>): Int {
    val endingPriority = PriorityQueue<IntArray> { o1, o2 ->
        when {
            o1[1] < o2[1] -> -1
            o1[1] == o2[1] -> 0
            else -> 1
        }
    }

    intervals.sortBy { it[0] }
    var max = 0
    intervals.forEach {
        if (endingPriority.isNotEmpty() && endingPriority.peek()[1] <= it[0]) endingPriority.remove()
        endingPriority.add(it)
        max = kotlin.math.max(max, endingPriority.size)
    }
    return max
}

fun main() {
    println(
        minMeetingRooms(
            arrayOf(
                arrayOf(13, 15).toIntArray(),
                arrayOf(1, 13).toIntArray()
            )
        )
    )
}