package leet_code.problems

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where
 * different letters represent different tasks. Tasks could be done without original order.
 * Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 *
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 3
 * Output: 8
 * Explanation: A -> B -> i -> i -> A -> B -> A -> B.
 *
 * Input: tasks = ["A","A","B","B","C","C"], n = 4
 * Output: 8
 * Explanation: A -> B -> C -> i -> A -> i -> B
 *
 *
 * Constraints:
 *
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
fun leastInterval(tasks: CharArray, n: Int): Int {
    // order according to most to least tasks
    // linked hash map of tasks in the window of the cooldown
    val taskCountMap = mutableMapOf<Char, Int>()
    tasks.forEach {
        taskCountMap[it] = taskCountMap.getOrPut(it, { 0 }) + 1
    }
    val entries = taskCountMap.entries.sortedBy { it.value }.toMutableList()
    val queue = mutableListOf<Char>()
    val contains = mutableSetOf<Char>()
    var intervals = 0
    var i = 0
    while (entries.isNotEmpty()) {
        val entry = entries[i]
        val key = entry.key

        if (contains.contains(key)) {
            queue.add('i')
            intervals++
        } else {
            queue.add(key)
            contains.add(key)
            intervals++

            entry.setValue(entry.value - 1)
            if (entry.value <= 0) entries.removeAt(i)
            else if (entries.isNotEmpty()) i = (i + 1) % entries.size
        }

        if (queue.size == (n + 1)) {
            val removedChar = queue.removeAt(0)
            contains.remove(removedChar)
        }
    }
    return intervals
}

fun main() {
    println(leastInterval(listOf('A', 'A', 'A', 'B', 'B', 'B').toCharArray(), 2))
    println(leastInterval(listOf('A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E').toCharArray(), 4))
}