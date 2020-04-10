object LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        var i = 0
        var j = 0
        var ans = 0
        val charSet = mutableSetOf<Char>()
        while (i < s.length && j < s.length) {
            if (!charSet.contains(s[j])) {
                charSet.add(s[j])
                j++
                ans = maxOf(ans, charSet.size)
            } else {
                charSet.remove(s[i])
                i++
            }
        }

        return ans
    }
}

fun main(args: Array<String>) {
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("aab"))
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbbbbbbbb"))
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"))
}
