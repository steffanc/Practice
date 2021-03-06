package leet_code.problems

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a
 * continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to
 * n*k where n is also an integer.
 *
 *
 * Example 1:
 *
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 *
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 *
 *
 * Constraints:
 *
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 *
 * O(n^2), O(1)
 */
fun checkSubarraySum1(nums: IntArray, k: Int): Boolean {
    for (i in nums.indices) {
        var sum = 0
        var count = 0
        for (j in i until nums.size) {
            sum += nums[j]
            if (count > 0) {
                if (sum == 0 && k == 0) return true
                else if (k != 0 && sum % k == 0) return true
            }
            count++
        }
    }
    return false
}

fun main() {
    println(checkSubarraySum1(intArrayOf(23, 2, 6, 4, 7), 6))
}