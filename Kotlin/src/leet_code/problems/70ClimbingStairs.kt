package leet_code.problems

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * O(n), O(1)
 */
fun climbStairs(n: Int): Int {
    val stairMap = mutableMapOf<Int, Int>()
    fun _climbStairs(n: Int): Int {
        if (stairMap.containsKey(n)) {
            return stairMap[n]!!
        }
        if (n == 0) return 1
        var count = 0
        if (n >= 1) count += _climbStairs(n - 1)
        if (n >= 2) count += _climbStairs(n - 2)
        stairMap[n] = count
        return count
    }
    return _climbStairs(n)
}

fun climbStairs2(n: Int): Int {
    if (n == 1) return 1
    val arr = (0 until n).toList().toTypedArray()
    arr[0] = 1
    arr[1] = 2
    for (i in 2 until arr.size) {
        arr[i] = arr[i - 1] + arr[i - 2]
    }
    return arr[n - 1]
}

fun main() {
    println(climbStairs2(5))
}