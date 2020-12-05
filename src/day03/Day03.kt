package day03

import java.math.BigInteger

class Day03 {
    fun solveAll() {
        println(solve1())
        println(solve2())
    }

    private fun solve1(): Int {
        val map = Map("resources/day03/input.txt")
        return map.countTreesForSlope(3, 1)
    }

    private fun solve2(): BigInteger {
        val map = Map("resources/day03/input.txt")
        return map.countTreesForSlope(1, 1).toBigInteger() *
                map.countTreesForSlope(3, 1).toBigInteger() *
                map.countTreesForSlope(5, 1).toBigInteger() *
                map.countTreesForSlope(7, 1).toBigInteger() *
                map.countTreesForSlope(1, 2).toBigInteger()
    }
}