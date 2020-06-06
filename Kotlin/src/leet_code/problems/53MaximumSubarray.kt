package leet_code.problems

import kotlin.math.max

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the
 * largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 *
 * O(n), O(1)
 */
fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    for (i in 1 until nums.size) {
        if (nums[i - 1] > 0) nums[i] += nums[i - 1]
        maxSum = max(maxSum, nums[i])
    }
    return maxSum
}

fun maxSubArray2(nums: IntArray): Int {
    var maxSum = nums[0]
    var sum = maxSum
    for (i in 1 until nums.size) {
        if (sum < 0) sum = nums[i]
        else sum += nums[i]
        maxSum = max(maxSum, sum)
    }
    return maxSum
}

fun main() {
    println(maxSubArray2(arrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).toIntArray()))
}