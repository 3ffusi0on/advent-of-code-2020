package day06

import java.io.File

class Day06()  {
    private val batch1Entries = mutableListOf<String>()
    private val batch2Entries = mutableListOf<MutableList<String>>()

    private fun formatBatch1() {
        val batchLine = File("resources/day06/input.txt").readLines();

        var isNewEntry = true
        for (line in batchLine) {
            if (line.isEmpty()) {
                isNewEntry = true
                continue
            }

            if (isNewEntry) {
                batch1Entries.add(line)
                isNewEntry = false
            } else {
                batch1Entries[batch1Entries.lastIndex] = batch1Entries.last().plus(line)
            }
        }
    }

    private fun formatBatch2() {
        val batchLine = File("resources/day06/input.txt").readLines();

        var subList = mutableListOf<String>()
        for (line in batchLine) {
            if (line.isEmpty()) {
                batch2Entries.add(subList)
                subList = mutableListOf()
                continue
            }
            subList.add(line)
        }
        batch2Entries.add(subList)
    }

    fun solveAll() {
        println(solve1())
        println(solve2())
    }

    private fun solve2(): Int {
        var result = 0
        formatBatch2()
        for (group in batch2Entries) {
            val groupResult = mutableListOf<Char>()
            group.forEachIndexed{i, dude ->
                if (i == 0) {
                    groupResult.addAll(dude.toCharArray().toList())
                } else {
                    for (char in dude.toCharArray()) {
                        if (!groupResult.contains(char)) {
                            groupResult.remove(char)
                        }
                    }
                    val copy = mutableListOf<Char>()
                    copy.addAll(groupResult)
                    for (char in copy) {
                        if (!dude.contains(char)) {
                            groupResult.remove(char)
                        }
                    }
                }
            }
            result += groupResult.size
        }
        return result
    }

    private fun solve1(): Int {
        formatBatch1()
        var result = 0
        for (line in batch1Entries) {
            val entries = mutableSetOf<Char>()
            entries.addAll(line.toCharArray().toList())
            result += entries.size
        }
        return result
    }


}