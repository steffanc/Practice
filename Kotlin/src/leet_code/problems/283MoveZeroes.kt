package leet_code.problems

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
fun moveZeroes(nums: IntArray): Unit {
    var j = nums.size - 1
    for (i in nums.size - 1 downTo 0) {
        if (nums[i] == 0) {
            val temp = nums[j]
            nums[j] = 0
            nums[i] = temp
            j--
        }
    }
}

fun main() {
    val a = arrayOf(0,0,1,2).toIntArray()
    moveZeroes(a)
    println(a.joinToString(","))
}