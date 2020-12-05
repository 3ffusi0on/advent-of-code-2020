package day04

import java.io.File

open class PassportChecker(private val batch: String) {
    val batchEntries = mutableListOf<String>()

    fun formatBatch() {
        val batchLine = File(batch).readLines();

        var isNewEntry = true
        for (line in batchLine) {
            if (line.isEmpty()) {
                isNewEntry = true
                continue
            }

            if (isNewEntry) {
                batchEntries.add(line)
                isNewEntry = false
            } else {
                batchEntries[batchEntries.lastIndex] = batchEntries.last().plus(" ").plus(line)
            }
        }
    }

    fun validateEntry(index: Int): Boolean {
        for (key in arrayOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")) {
            if (!entryHasValidKey(index, key))
                return false
        }
        return true
    }

    open fun entryHasValidKey(index: Int, key: String): Boolean {
        return Regex("$key:[\\w#]+").containsMatchIn(batchEntries[index])
    }

    fun validate(): Int {
        var validEntries = 0
        batchEntries.forEachIndexed { index, _ ->
            if (validateEntry(index)) {
                validEntries++
            }

        }
        return validEntries
    }
}