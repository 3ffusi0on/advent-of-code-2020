package day08

import java.io.File

class BootLoader(private var instructions : List<String>) {
    private var assert = false

    fun run(): Int {
        var accCount = 0
        val visitedIndexes = mutableListOf<Int>()
        var instructionIndex = 0
        while (true) {
            if (visitedIndexes.contains(instructionIndex)) {
                if (assert) {
                    throw Exception()
                }
                break
            }
            visitedIndexes.add(instructionIndex)
            val input = Regex("(\\w{3}) ([-+]\\d+)").find(instructions[instructionIndex])
            val inst = input!!.groups[1]!!.value
            val value = input.groups[2]!!.value.toInt()

            when (inst) {
                "acc" -> {
                    accCount += value
                    instructionIndex++
                }
                "jmp" -> {
                    instructionIndex += value
                }
                "nop" -> {
                    instructionIndex++
                }
            }
            if (instructionIndex == instructions.size) {
                return accCount
            }
        }
        return accCount
    }

    fun enableAssertMode() {
        assert = true
    }

    fun setInstructions(instructions : List<String>) {
        this.instructions = instructions
    }
}
