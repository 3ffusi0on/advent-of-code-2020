package day04

class Day04 {
    fun solveAll() {
        println(solve1())
        println(solve2())
    }

    private fun solve1(): Int {
        val passportChecker = PassportChecker("resources/day04/input.txt")
        passportChecker.formatBatch()
        return passportChecker.validate()
    }

    private fun solve2(): Int {
        val passportChecker = AdvancedPassportChecker("resources/day04/input2.txt")
        passportChecker.formatBatch()
        return passportChecker.validate()
    }
}