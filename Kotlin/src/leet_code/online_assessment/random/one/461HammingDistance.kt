package leet_code.online_assessment.random.one

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */

fun hammingDistance(x: Int, y: Int): Int {
    var diffInt = x.xor(y)
    var count = 0
    while (diffInt != 0) {
        count += diffInt.and(1)
        diffInt = diffInt.ushr(1)
    }
    return count
}

fun main(args: Array<String>) {
    println(hammingDistance(0, 1))
}
