package leet_code.problems

fun twoSum1Pass(nums: IntArray, target: Int): IntArray {
    val numToIndexMap = mutableMapOf<Int, Int>()
    nums.forEachIndexed { i, num ->
        val j = numToIndexMap.getOrDefault(target - num, -1)
        if (j != i && j >= 0) {
            return listOf(i,j).toIntArray()
        }
        numToIndexMap[num] = i
    }
    throw IllegalStateException()
}

fun twoSum2Pass(nums: IntArray, target: Int): IntArray {
    val numToIndexMap = nums.mapIndexed { i, num -> num to i }.toMap()
    nums.forEachIndexed { i, num ->
        val j = numToIndexMap.getOrDefault(target - num, -1)
        if (j != i && j >= 0) {
            return listOf(i,j).toIntArray()
        }
    }
    throw IllegalStateException()
}

fun twoSumBrute(nums: IntArray, target: Int): IntArray {
    for (i in 0 until nums.size - 1) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return listOf(i,j).toIntArray()
            }
        }
    }
    throw IllegalStateException()
}

fun main() {
    val test = listOf(230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70, 435, 384, 778, 887, 755, 740, 337, 86, 92, 325, 422, 815, 650, 920, 125, 277, 336, 221, 847, 168, 23, 677, 61, 400, 136, 874, 363, 394, 199, 863, 997, 794, 587, 124, 321, 212, 957, 764, 173, 314, 422, 927, 783, 930, 282, 306, 506, 44, 926, 691, 568, 68, 730, 933, 737, 531, 180, 414, 751, 28, 546, 60, 371, 493, 370, 527, 387, 43, 541, 13, 457, 328, 227, 652, 365, 430, 803, 59, 858, 538, 427, 583, 368, 375, 173, 809, 896, 370, 789)
    val answer = twoSum1Pass(IntArray(test.size) { test[it] }, 542)
    println("${answer[0]}, ${answer[1]}")
}