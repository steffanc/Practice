package leet_code.problems

import kotlin.math.max

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val mergeIntervals = mutableListOf<IntArray>()
    intervals.sortBy { it[0] }
    intervals.forEach { interval ->
        if (mergeIntervals.isEmpty()) {
            mergeIntervals.add(interval)
        } else {
            val index = mergeIntervals.lastIndex
            val mergeInterval = mergeIntervals[index]
            if (interval[0] >= mergeInterval[0] && interval[0] <= mergeInterval[1]) {
                mergeIntervals[index] =
                    IntArray(2).also { it[0] = mergeInterval[0]; it[1] = max(interval[1], mergeInterval[1]) }
            } else {
                mergeIntervals.add(interval)
            }
        }
    }
    return mergeIntervals.toTypedArray()
}

fun main(args: Array<String>) {
    println(
        merge(
            listOf<IntArray>(
                IntArray(2).also { it[0] = 1; it[1] = 3 },
                IntArray(2).also { it[0] = 2; it[1] = 6 },
                IntArray(2).also { it[0] = 8; it[1] = 10 },
                IntArray(2).also { it[0] = 15; it[1] = 28 }
            ).toTypedArray()
        ).flatMap { it.asList() }
    )
}
