package leet_code.problems

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
 *
 * Example 1:
 * Input: 123
 * Output: "One Hundred Twenty Three"
 *
 * Example 2:
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 *
 * Example 3:
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * Example 4:
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
fun numberToWords(num: Int): String {
    if (num == 0) return "Zero"

    val out = mutableListOf<String>()
    val numStr = num.toString().reversed()
    numStr.chunked(3).forEachIndexed { i, str ->
        when (i) {
            1 -> if (str != "000") out.add("Thousand")
            2 -> if (str != "000") out.add("Million")
            3 -> if (str != "000") out.add("Billion")
        }

        str.forEachIndexed { j, char ->
            when (j) {
                0 -> {
                    if (char != '0' && str.getOrNull(j + 1) != '1') {
                        out.add(ones(char.toString()))
                    }
                }
                1 -> {
                    if (char == '1') {
                        out.add(tens(char.toString() + str[j - 1].toString()))
                    } else if (char != '0') {
                        out.add(twentyPlus(char.toString()))
                    }
                }
                2 -> {
                    if (char != '0') {
                        out.add("Hundred")
                        out.add(ones(char.toString()))
                    }
                }
            }
        }
    }
    return out.reversed().joinToString(" ")
}

fun ones(str: String): String {
    return when (str) {
        "1" -> "One"
        "2" -> "Two"
        "3" -> "Three"
        "4" -> "Four"
        "5" -> "Five"
        "6" -> "Six"
        "7" -> "Seven"
        "8" -> "Eight"
        "9" -> "Nine"
        else -> ""
    }
}

fun tens(str: String): String {
    return when (str) {
        "10" -> "Ten"
        "11" -> "Eleven"
        "12" -> "Twelve"
        "13" -> "Thirteen"
        "14" -> "Fourteen"
        "15" -> "Fifteen"
        "16" -> "Sixteen"
        "17" -> "Seventeen"
        "18" -> "Eighteen"
        "19" -> "Nineteen"
        else -> ""
    }
}

fun twentyPlus(str: String): String {
    return when (str) {
        "2" -> "Twenty"
        "3" -> "Thirty"
        "4" -> "Forty"
        "5" -> "Fifty"
        "6" -> "Sixty"
        "7" -> "Seventy"
        "8" -> "Eighty"
        "9" -> "Ninety"
        else -> ""
    }
}

fun main() {
    println(numberToWords(913))
}
