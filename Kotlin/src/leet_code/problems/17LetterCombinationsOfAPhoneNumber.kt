package leet_code.problems

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
 * could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map
 * to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val numMap =
        mapOf(
            1 to arrayOf(),
            2 to arrayOf('a', 'b', 'c'),
            3 to arrayOf('d', 'e', 'f'),
            4 to arrayOf('g', 'h', 'i'),
            5 to arrayOf('j', 'k', 'l'),
            6 to arrayOf('m', 'n', 'o'),
            7 to arrayOf('p', 'q', 'r', 's'),
            8 to arrayOf('t', 'u', 'v'),
            9 to arrayOf('w', 'x', 'y', 'z'),
            0 to arrayOf(' ')
        )

    val out = mutableListOf<String>()
    fun _letterCombinations(digits: String, i: Int, combo: String) {
        if (i == digits.length) {
            out.add(combo)
            return
        }

        numMap[Character.getNumericValue(digits[i])]!!.forEach {
            _letterCombinations(digits, i + 1, combo + it)
        }
    }
    _letterCombinations(digits, 0, "")
    return out
}

fun main() {
    println(letterCombinations("23"))
}