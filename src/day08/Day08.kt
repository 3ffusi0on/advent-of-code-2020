package day08

import java.io.File

class Day08 {
    fun solveAll() {
        println(solve1())
        println(solve2())
    }

    private fun solve1(): Int {
        val instructions : List<String> = File("resources/day08/input.txt").readLines()
        return (BootLoader(instructions)).run()
    }

    private fun solve2(): Int {
        val instructions : List<String> = File("resources/day08/input.txt").readLines()
        val bootLoader = BootLoader(instructions)
        bootLoader.enableAssertMode()

        for (i in 0..instructions.size) {
            val copy = ArrayList(instructions)
            try {
                val instName  = instructions[i].subSequence(0, 3)
                if (instName == "nop") {
                    copy[i] = "jmp" + instructions[i].subSequence(3, instructions[i].length)
                } else if (instName == "jmp") {
                    copy[i] = "nop" + instructions[i].subSequence(3, instructions[i].length)
                } else {
                    continue
                }

                bootLoader.setInstructions(copy)
                return bootLoader.run()
            } catch (_: Exception) {
                continue
            }
        }

        throw Exception("Impossible")
    }
}