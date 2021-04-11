package day07

class Bag(internal val color: String) {
    internal val subBags = mutableMapOf<String, Int>()

    public fun addSubBag(bag: Bag, quantity: Int) {
        subBags[bag.color] = quantity
    }
}