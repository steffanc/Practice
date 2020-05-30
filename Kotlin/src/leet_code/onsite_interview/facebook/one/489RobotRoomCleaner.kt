package leet_code.onsite_interview.facebook.one


/**
 * Given a robot cleaner in a room modeled as a grid.
 *
 * Each cell in the grid can be empty or blocked.
 *
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 *
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 *
 * interface Robot {
 * // returns true if next cell is open and robot moves into the cell.
 * // returns false if next cell is obstacle and robot stays on the current cell.
 * boolean move();
 *
 * // Robot will stay on the same cell after calling turnLeft/turnRight.
 * // Each turn will be 90 degrees.
 * void turnLeft();
 * void turnRight();
 *
 * // Clean the current cell.
 * void clean();
 * }
 *
 * Example:
 *
 * Input:
 * room = [
 * [1,1,1,1,1,0,1,1],
 * [1,1,1,1,1,0,1,1],
 * [1,0,1,1,1,1,1,1],
 * [0,0,0,1,0,0,0,0],
 * [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 *
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 *
 * Notes:
 * The input is only given to initialize the room and the robot's position internally.
 * You must solve this problem "blindfolded". In other words, you must control the robot using only the
 * mentioned 4 APIs, without knowing the room layout and the initial robot's position.
 * The robot's initial position will always be in an accessible cell.
 * The initial direction of the robot will be facing up.
 * All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
 * Assume all four edges of the grid are all surrounded by wall.
 */

/**
 * // This is the Robot's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     fun move(): Boolean {}
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     fun turnLeft() {}
 *     fun turnRight() {}
 *
 *     // Clean the current cell.
 *     fun clean() {}
 * }
 */

class Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    fun move(): Boolean {
        return true
    }

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    fun turnLeft() {}
    fun turnRight() {}

    // Clean the current cell.
    fun clean() {}
}

enum class DIR(val pair: Pair<Int, Int>) { N(Pair(0, 1)), E(Pair(1, 0)), S(Pair(0, -1)), W(Pair(-1, 0)) }

fun cleanRoom(robot: Robot) {
    val visited = mutableSetOf<Pair<Int, Int>>()
    fun _cleanRoom(robot: Robot, dir: DIR, x: Int, y: Int) {
        if (visited.contains(x to y)) return

        robot.clean()
        visited.add(x to y)

        var _dir = dir
        // facing, left, right, back
        if (!visited.contains(x + _dir.pair.first to y + _dir.pair.second) && robot.move()) {
            _cleanRoom(robot, _dir, x + _dir.pair.first, y + _dir.pair.second)
            robot.turnRight()
        } else {
            robot.turnLeft()
        }

        _dir = DIR.values()[(_dir.ordinal + 3) % 4]
        if (!visited.contains(x + _dir.pair.first to y + _dir.pair.second) && robot.move()) {
            _cleanRoom(robot, _dir, x + _dir.pair.first, y + _dir.pair.second)
        } else {
            robot.turnRight()
            robot.turnRight()
        }

        _dir = DIR.values()[(_dir.ordinal + 2) % 4]
        if (!visited.contains(x + _dir.pair.first to y + _dir.pair.second) && robot.move()) {
            _cleanRoom(robot, _dir, x + _dir.pair.first, y + _dir.pair.second)
            robot.turnLeft()
        } else {
            robot.turnRight()
        }

        _dir = DIR.values()[(_dir.ordinal + 1) % 4]
        robot.move()
        if (!visited.contains(x + _dir.pair.first to y + _dir.pair.second)) {
            _cleanRoom(robot, _dir, x + _dir.pair.first, y + _dir.pair.second)
        }
    }
    _cleanRoom(robot, DIR.N, 0, 0)
}

fun main() {
    println((3 + 3) % 4)
}