package day07

import Day
import java.io.File

class Day07: Day() {

    override fun solve1(): Int {
        val bagList = getBagList()
        var possibilities = setOf<String>()
        for (bag in bagList) {
            bag.subBags
            if (bag.color === "shiny gold") {

            }
        }

        return possibilities.size
    }

    override fun solve2(): Int {
        return 0
    }

    private fun getBagList(): MutableList<Bag> {
        val bagList = mutableListOf<Bag>()
        val rawBags = File("resources/day07/input-test.txt").readLines()
        rawBags.forEach { line ->
            val parsedBag = Regex("(\\w+ \\w+) bags contain").find(line)
            val color = parsedBag!!.groups[1]!!.value
            val bag = Bag(color)
            val rawSubBags = Regex(" (\\d+) (\\w+ \\w+) \\w+[,.]")
                .findAll(line, color.length + " bags contain ".length -1)
            rawSubBags.forEach {
                bag.addSubBag(
                    Bag(it.groups[2]!!.value),
                    it.groups[1]!!.value.toInt()
                )
            }
            bagList.add(bag)
        }
        return bagList
    }
}