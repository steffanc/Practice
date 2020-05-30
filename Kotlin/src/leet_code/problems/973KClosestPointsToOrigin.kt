package leet_code.problems

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 *
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
    points.sortBy { sqrt(it[0].toDouble().pow(2) + it[1].toDouble().pow(2)) }
    return points.take(K).toTypedArray()
}

fun kClosest2(points: Array<IntArray>, K: Int): Array<IntArray> {
    val minHeap = PriorityQueue<Pair<Pair<Int, Int>, Double>>(K) { o1, o2 -> (o1.second - o2.second).toInt() }
    points.forEach { minHeap.add(Pair(Pair(it[0], it[1]), sqrt(it[0].toDouble().pow(2) + it[1].toDouble().pow(2)))) }
    return (0 until K).map { minHeap.remove() }.map { arrayOf(it.first.first, it.first.second).toIntArray() }
        .toTypedArray()
}

fun main() {
    println(kClosest2(arrayOf(arrayOf(3, 3).toIntArray(), arrayOf(5, -1).toIntArray(), arrayOf(-2, 4).toIntArray()), 2))
    println(kClosest2(arrayOf(arrayOf(1, 3).toIntArray(), arrayOf(-2, 2).toIntArray()), 1))
}

