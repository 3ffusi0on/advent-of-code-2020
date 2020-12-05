package day05

class Node(
    var min: Int,
    var max: Int
){
    var lower: Node? = null
    var higher: Node? = null

    fun buildBranches() {
        if (max - min > 1) {
            val pivot = min + (max - min) /2
            lower = Node(min, pivot)
            lower!!.buildBranches()
            higher = Node(pivot + 1, max)
            higher!!.buildBranches()
        }
    }

    fun find(pass: String): Int {
        val letter = pass[0]
        if (pass.length == 1) {
            return if (letter == 'F' || letter == 'L') min else max
        }

        if (lower == null || higher == null) {
            throw Exception()
        }

        return if (letter == 'F' || letter == 'L') lower!!.find(pass.substring(1)) else higher!!.find(pass.substring(1))
    }

}