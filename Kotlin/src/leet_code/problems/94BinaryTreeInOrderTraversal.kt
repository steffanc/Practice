package leet_code.problems

import leet_code.TreeNode

fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    if (root?.left != null) {
        list.addAll(inorderTraversal(root.left))
    }

    root?.`val`?.let { list.add(it) }

    if (root?.right != null) {
        list.addAll(inorderTraversal(root.right))
    }

    return list
}

fun main() {
    val tree1 = TreeNode(1).also {
        it.right = TreeNode(2)
            .also { it.left = TreeNode(3) }
    }
    println(inorderTraversal(tree1))
}
