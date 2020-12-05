package day05

import java.io.File

class Day05 {
    fun solveAll() {
        println(solve1())
        println(solve2())
    }

    private fun solve2(): Int {
        val boardingsIds = getBoardingPassIds()
        val maxId = boardingsIds.maxOrNull()
        val minId = boardingsIds.minOrNull()
        for (i in minId!!..maxId!!) {
            if (boardingsIds.indexOf(i) == -1) { // "only missing"
                return i
            }
        }
        return 0
    }

    private fun solve1(): Int? {
        val boardingsIds = getBoardingPassIds()
        return boardingsIds.maxOrNull()
    }

    private fun getBoardingPassIds(): ArrayList<Int> {
        val boardings = File("resources/day05/input.txt").readLines();
        val plane = Plane()
        val boardingsIds = arrayListOf<Int>()
        boardings.forEach {
            val row = it.subSequence(0, 7).toString()
            val seat = it.subSequence(7, 10).toString()
            val rowNbr = plane.findRow(row)
            val seatNbr = plane.findSeat(seat)
            val id = rowNbr * 8 + seatNbr
            boardingsIds.add(id)
        }
        return boardingsIds
    }
}