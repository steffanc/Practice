package leet_code.phone_interview.google.one

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 *
 * O(log(n)), O(1)
 */

abstract class VersionControl {
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(version: Int): Boolean = true
}

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        fun _firstBadVersion(low: Int, high: Int): Int {
            val mid = low + (high - low) / 2
            return if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) mid
                else _firstBadVersion(low, mid - 1)
            } else {
                if (isBadVersion(mid + 1)) mid + 1
                else _firstBadVersion(mid + 1, high)
            }
        }
        return _firstBadVersion(1, n)
    }
}

class Solution2 : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var low = 1
        var high = n
        while (true) {
            val mid = low + (high - low) / 2
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) return mid
                else high = mid - 1
            } else {
                if (isBadVersion(mid + 1)) return mid + 1
                else low = mid + 1
            }
        }
    }
}
