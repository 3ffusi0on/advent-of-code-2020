package day03

import java.io.File

class Map(blueprint: String) {
    var content: List<String> = File(blueprint).readLines();
    var length = content[0].length
    var height = content.size

    fun isTree(x: Int, y: Int): Boolean {
        return getCell(x, y) == '#'
    }

    fun getCell(x: Int, y: Int): Char {
        return content[y][x % length]
    }

    fun isValid(y: Int): Boolean {
        return y < height
    }

    fun countTreesForSlope(slopeX: Int, slopeY: Int): Int {
        var x = 0
        var y = 0
        var trees = 0

        while (isValid(y)) {
            x += slopeX
            y += slopeY
            if (isValid(y) && isTree(x, y)) {
                trees++
            }
        }
        return trees
    }
}