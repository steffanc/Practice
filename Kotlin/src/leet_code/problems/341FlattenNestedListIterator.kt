package leet_code.problems

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list.
//    constructor()

    // Constructor initializes a single integer.
//    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>?
}

data class MutablePair<A, B>(var first: A, var second: B)

class NestedIterator(nestedList: List<NestedInteger>) {
    private val stack = mutableListOf<MutablePair<List<NestedInteger>, Int>>()
    private var current: MutablePair<List<NestedInteger>, Int>? = MutablePair(nestedList, 0)

    tailrec fun next(): Int {
        val list = current!!.first
        val i = current!!.second++
        return if (list[i].isInteger()) {
            if (i == list.size - 1) current = if (stack.isEmpty()) null else stack.removeAt(0)
            list[i].getInteger()!!
        } else {
            if (i != list.size - 1) stack.add(0, current!!)
            current = MutablePair(list[i].getList()!!, 0)
            next()
        }
    }

//    fun hasNext(): Boolean {
//        fun _hasNext(l: List<NestedInteger>?, i: Int?): Boolean {
//            return !l.isNullOrEmpty() && (l[i!!].isInteger() || _hasNext(l[i].getList(), 0))
//        }
//        return _hasNext(current?.first, current?.second) || _hasNext(stack.first().first, stack.first())
//    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */