package leet_code.problems

import kotlin.math.min

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting
 * house 1 with color green, and so on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Example:
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 *
 * O(n), O(n)
 */
fun minCost(costs: Array<IntArray>): Int {
    fun _minCost(costs: Array<IntArray>, level: Int, costMap: MutableMap<Pair<Int, Int>, Int>, prevChoice: Int): Int {
        if (level == costs.size) return 0

        var minCost = Int.MAX_VALUE
        for (i in costs[level].indices) {
            if (i == prevChoice) continue
            val cost = if (costMap.containsKey(level to i)) {
                costMap[level to i]!!
            } else {
                costs[level][i] + _minCost(costs, level + 1, costMap, i)
            }
            costMap[level to i] = cost
            minCost = min(cost, minCost)
        }
        return minCost
    }
    return _minCost(costs, 0, mutableMapOf(), -1)
}

/**
 * O(n), O(1)
 */
fun minCost2(costs: Array<IntArray>): Int {
    for (i in costs.size - 2 downTo 0) {
        for (j in costs[i].indices) {
            costs[i][j] = costs[i][j] + when (j) {
                0 -> min(costs[i + 1][1], costs[i + 1][2])
                1 -> min(costs[i + 1][0], costs[i + 1][2])
                2 -> min(costs[i + 1][0], costs[i + 1][1])
                else -> 0
            }
        }
    }
    return min(costs[0][0], min(costs[0][1], costs[0][2]))
}

fun main() {
    println(
        minCost2(
            arrayOf(
                arrayOf(17, 2, 17).toIntArray(),
                arrayOf(16, 16, 5).toIntArray(),
                arrayOf(14, 3, 19).toIntArray()
            )
        )
    )
}