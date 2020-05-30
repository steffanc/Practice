package leet_code.phone_interview.random.one

/**
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
fun permute(nums: IntArray): List<List<Int>> {
    val out = mutableListOf<List<Int>>()
    fun doPermute(nums: IntArray, _out: List<Int>, used: BooleanArray) {
        if (_out.size == nums.size) {
            out.add(_out)
            return
        }

        nums.forEachIndexed { index, i ->
            if (!used[index]) {
                used[index] = true
                doPermute(nums, _out + i, used)
                used[index] = false
            }
        }
    }
    doPermute(nums, mutableListOf(), BooleanArray(nums.size) { false })
    return out
}

fun main(args: Array<String>) {
    println(permute(IntArray(2) { it }))
}
