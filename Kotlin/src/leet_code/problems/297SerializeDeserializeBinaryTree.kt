package leet_code.problems

import leet_code.TreeNode

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be
 * reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4  5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not
 * necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Codec() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val values = mutableListOf<String>()
        fun _serialize(root: TreeNode?) {
            values.add(root?.`val`.toString())
            if (root == null) {
                return
            }

            _serialize(root.left)
            _serialize(root.right)
        }
        _serialize(root)
        return values.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        fun _deserialize(data: MutableList<String>): TreeNode? {
            val value = data.removeAt(0)
            if (value == "null") {
                return null
            }

            val node = TreeNode(value.toInt())
            node.left = _deserialize(data)
            node.right = _deserialize(data)
            return node
        }
        return _deserialize(data.split(",").toMutableList())
    }
}

class Codec2() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val nodes = mutableListOf(root)
        val strs = mutableListOf<String>()
        while (nodes.isNotEmpty()) {
            val node = nodes.removeAt(0)
            strs.add(node?.`val`.toString())
            if (node != null) {
                nodes.add(node.left)
                nodes.add(node.right)
            }
        }
        return strs.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val strs = data.split(",").toMutableList()
        if (strs.isEmpty()) return null

        val str = strs.removeAt(0)
        if (str == "null") return null
        val root = TreeNode(str.toInt())
        val nodes = mutableListOf(root)
        while (strs.isNotEmpty()) {
            val node = nodes.removeAt(0)
            val strL = strs.removeAt(0)
            node.left = if (strL == "null") null else TreeNode(strL.toInt())
            node.left?.let { nodes.add(it) }

            val strR = strs.removeAt(0)
            node.right = if (strR == "null") null else TreeNode(strR.toInt())
            node.right?.let { nodes.add(it) }
        }
        return root
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var data = obj.encode(longUrl)
 * var ans = obj.decode(data)
 */

fun main() {
    val codec = Codec2()
    val serialize = codec.serialize(null)
    println(serialize)
//    TreeNode(1).also {
//        it.left = TreeNode(2).also {
//            it.left = TreeNode(4)
//            it.right = TreeNode(5)
//        }
//        it.right = TreeNode(3)
//    }

    val deserialize = codec.deserialize(serialize)
    println(deserialize)
}