package leet_code.phone_interview.google.two

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the
 * remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return anything from your function.
 *
 *
 * Example 1:
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 *
 * Example 2:
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 * Note:
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 *
 * O(n), O(1)
 */
fun duplicateZeros(arr: IntArray): Unit {
    var zeroCount = arr.sumBy { if (it == 0) 1 else 0 }
    for (i in arr.size - 1 downTo 0) {
        if (i + zeroCount < arr.size) arr[i + zeroCount] = arr[i]
        if (arr[i] == 0 && i + zeroCount - 1 < arr.size) arr[i + zeroCount - 1] = 0
        if (arr[i] == 0) zeroCount--
    }
}

fun main() {
    val arr = arrayOf(1, 0, 2, 3, 0, 4, 5, 0).toIntArray()
    duplicateZeros(arr)
    println(arr.joinToString(","))
}