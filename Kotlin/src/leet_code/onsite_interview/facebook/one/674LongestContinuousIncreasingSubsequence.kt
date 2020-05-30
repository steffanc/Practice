package leet_code.onsite_interview.facebook.one

/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 *
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 *
 * Note: Length of the array will not exceed 10,000.
 */
fun findLengthOfLCIS(nums: IntArray): Int {
    var maxLength = 0
    var currLength = 0
    var lastNum: Int? = null
    for (num in nums) {
        if (lastNum == null || num > lastNum) {
            currLength++
        } else {
            currLength = 1
        }
        lastNum = num
        if (currLength > maxLength) maxLength = currLength
    }
    return maxLength
}

fun main() {
    println(findLengthOfLCIS(arrayOf(1,3,5,4,2,3,4,5).toIntArray()))
}
