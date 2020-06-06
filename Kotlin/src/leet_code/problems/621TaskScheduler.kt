package leet_code.problems

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
 * represent different tasks. Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least
 * n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 *
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 *
 * Example:
 * Input: tasks = ["A","A","A","A","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> idle -> idle -> A.
 *
 * Constraints:
 *
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
fun leastInterval(tasks: CharArray, n: Int): Int {
    val tasksMap = mutableMapOf<Char, Int>()
    tasks.forEach { tasksMap[it] = tasksMap.getOrDefault(it, 0) + 1 }
    val priority = tasksMap.entries.sortedBy { it.value }.toMutableList()

    var coolingCount: Int
    var totalWorkCount = 0
    while (true) {
        coolingCount = 0
        val iter = priority.iterator()
        while (iter.hasNext()) {
            val entry = iter.next()
            entry.setValue(entry.value - 1)
            if (entry.value == 0) iter.remove()
            coolingCount++
            totalWorkCount++
            if (coolingCount == n) break
        }
        if (priority.isEmpty()) break
        totalWorkCount += n - coolingCount + 1
    }

    return totalWorkCount
}

fun main() {
    println(leastInterval(listOf('A', 'A', 'A', 'A', 'B', 'B').toCharArray(), 2))
    println(leastInterval(listOf('A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E').toCharArray(), 4))
}