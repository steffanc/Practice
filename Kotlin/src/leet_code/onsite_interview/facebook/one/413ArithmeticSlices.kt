package leet_code.onsite_interview.facebook.one

/**
 * A sequence of number is called arithmetic if it consists of at least three elements and
 * if the difference between any two consecutive elements is the same.
 *
 * For example, these are arithmetic sequence:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 *
 * The following sequence is not arithmetic.
 * 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers
 * (P, Q) such that 0 <= P < Q < N.
 *
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 *
 * The function should return the number of arithmetic slices in the array A.
 *
 * Example:
 * A = [1, 2, 3, 4]
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 *
 * A = [1, 2, 3, 5, 7]
 * A = [1, 2, 3, 4, 5]
 * 123, 234, 345, 1234, 2435, 12345
 *
 * A = [1, 2, 3, 4, 5, 6]
 * 123, 234, 345, 456, 1234, 2435, 3456, 12345, 24356, 123456
 *
 * O(n), O(1)
 */
fun numberOfArithmeticSlices(A: IntArray): Int {
    if (A.size < 3) return 0
    val sequences = mutableListOf<Int>()
    var prevNum = A.first()
    var diff = A[1] - A[0]
    var count = 1
    for (i in 1 until A.size) {
        val curDiff = A[i] - prevNum
        if (curDiff == diff) {
            count++
        } else {
            if (count >= 3) sequences.add(count)
            diff = curDiff
            count = 2
        }
        prevNum = A[i]
    }
    if (count >= 3) sequences.add(count)
    fun sumSeries(n: Int) = (n * (n + 1)) / 2
    return sequences.fold(0, { acc, i -> acc + sumSeries(i - 2) })
}

fun main() {
    println(numberOfArithmeticSlices(arrayOf(1,2,3,5,7).toIntArray()))
}