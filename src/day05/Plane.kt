package day05

class Plane {
    var rowsTree: Node = buildTree(127)
    var seatsTree: Node = buildTree(7)

    private fun buildTree(maxValue : Int): Node {
        val tree = Node(0, maxValue)
        tree.buildBranches()
        return tree
    }

    fun findRow(pass: String): Int {
        return rowsTree.find(pass)
    }

    fun findSeat(pass: String): Int {
        return seatsTree.find(pass)
    }
}