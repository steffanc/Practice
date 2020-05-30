package leet_code.phone_interview.random.one

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 *
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
class Node {
    private val chars = Array<Node?>(26) { null }
    private var isWord = false

    fun insert(word: String) {
        if (word.isEmpty()) {
            isWord = true
            return
        }

        val index = charToInt(word.first())
        val node = chars[index] ?: Node()
        chars[index] = node
        node.insert(word.slice(1 until word.length))
    }

    fun search(word: String): Boolean {
        if (word.isEmpty()) {
            return isWord
        }

        val node = chars[charToInt(word.first())] ?: return false

        return node.search(word.slice(1 until word.length))
    }

    fun startsWith(prefix: String): Boolean {
        if (prefix.isEmpty()) {
            return true
        }

        val node = chars[charToInt(prefix.first())] ?: return false

        return node.startsWith(prefix.slice(1 until prefix.length))
    }

    private fun charToInt(char: Char) = char.toInt() - aAscii

    companion object {
        private const val aAscii = 'a'.toInt()
    }
}

class Trie {
    /** Initialize your data structure here. */
    val root = Node()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        root.insert(word)
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        return root.search(word)
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        return root.startsWith(prefix)
    }
}

fun main(args: Array<String>) {
    val trie = Trie()
    trie.insert("app")
    trie.insert("apps")
    println(trie.search("app"))
}
