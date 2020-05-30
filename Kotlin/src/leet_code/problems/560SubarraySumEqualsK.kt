package leet_code.problems

/**
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 *
 * Constraints:
 *
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */

/**
 * Time: O(n^2), Space: O(1)
 */
fun subarraySum(nums: IntArray, k: Int): Int {
    var count = 0
    for (i in nums.indices) {
        var sum = nums[i]
        if (sum == k) {
            count++
        }
        for (j in i + 1 until nums.size) {
            sum += nums[j]
            if (sum == k) {
                count++
            }
        }
    }
    return count
}

/**
 * O(n)
 */
fun subarraySum2(nums: IntArray, k: Int): Int {
    var count = 0
    var sum = 0
    val map = mutableMapOf<Int, Int>()
    map[0] = 1;
    for (i in nums.indices) {
        sum += nums[i]
        if (map.containsKey(sum - k)) {
            count += map[sum - k]!!
        }
        map[sum] = map.getOrDefault(sum, 0) + 1
    }
    return count
}

fun main() {
    println(subarraySum(listOf(1, 1, -1, 1, -1).toIntArray(), 0))
}