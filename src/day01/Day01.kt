package day01

import java.io.File
import java.lang.Exception

class Day01 {
    private val values = mutableListOf<Int>()

    fun solveAll() {
        init()
//        println(solve1(values.toMutableList()))
        println(solve2(values.toMutableList()))
    }

    private fun init() {
        val rawValues = File("resources/day01/input.txt")
            .readText()
            .split("\n")
        rawValues.forEach { values.add(it.trim().toInt()) }
    }

    private fun solve1(values: MutableList<Int>, missing: Int = 2020): Int {
        while (values.isNotEmpty()) {
            val first = values.first()
            values.remove(first)
            if (values.contains(missing - first)) {
                return first * (missing - first)
            }
        }
        throw Exception("Impossible !")
    }

    private fun solve2(values: MutableList<Int>): Int {

        while (values.isNotEmpty()) {
            try {
                val first = values.first()
                values.remove(first)
                return first * solve1(values.toMutableList(), 2020 - first)
            } catch (_ :Exception) {
                continue
            }
        }

        throw Exception("Impossible !")
    }
}