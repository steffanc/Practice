package leet_code.problems

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
fun generateParenthesis(n: Int): List<String> {
    val out = mutableListOf<String>()
    fun doGenerate(str: String, depth: Int, maxDepth: Int, opens: Int, closeds: Int) {
        if (depth == maxDepth) {
            out.add(str)
            return
        }

        if (opens < maxDepth / 2) {
            doGenerate("$str(", depth + 1, maxDepth, opens + 1, closeds)
        }
        if (opens - closeds > 0) {
            doGenerate("$str)", depth + 1, maxDepth, opens, closeds + 1)
        }
    }
    doGenerate("", 0, n * 2, 0, 0)
    return out
}

fun main(args: Array<String>) {
    println(generateParenthesis(3))
}
