package day02

import java.io.File

class Day02 {
    private var values: List<String> = emptyList()
    fun solveAll() {
        init()
        println(solve1())
        println(solve2())
    }

    private fun init() {
        values = File("resources/day02/input.txt")
            .readLines()
    }

    private fun solve1(): Int {
        var validPassword = 0
        val regex = Regex("(\\d+)-(\\d+) ([a-z]): ([a-z]+)")
        for (line in values) {
            val input = regex.find(line)
            val min = input?.groups?.get(1)?.value?.toInt()
            val max = input?.groups?.get(2)?.value?.toInt()
            val letter = input?.groups?.get(3)?.value.toString()
            val password = input?.groups?.get(4)?.value.toString()

            val pattern = Regex("[$letter]")
            val matches =  pattern.findAll(password).count()
            if (matches >= min!! && matches <= max!!) {
                validPassword++
            }
        }
        return validPassword
    }

    private fun solve2(): Int {
        var validPassword = 0
        val regex = Regex("(\\d+)-(\\d+) ([a-z]): ([a-z]+)")
        for (line in values) {
            val input = regex.find(line)
            val a = input?.groups?.get(1)?.value?.toInt()
            val b = input?.groups?.get(2)?.value?.toInt()
            val letter = input?.groups?.get(3)?.value.toString()
            val password = input?.groups?.get(4)?.value.toString()

            var valid = false
            for (op in arrayOf(password[a!! - 1] == letter[0], password[b!! - 1] == letter[0])) {
                if (op) {
                    valid = !valid
                }
            }
            if (valid) {
                validPassword++
            }
        }
        return validPassword
    }
}