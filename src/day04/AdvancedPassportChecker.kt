package day04

class AdvancedPassportChecker(private val batch: String): PassportChecker(batch) {
    private val rules = mapOf<String, String>(
        "byr" to "^(19[2-8][0-9]|199[0-9]|200[0-2])$",
        "iyr" to "^(201[0-9]|2020)$",
        "eyr" to "^(202[0-9]|2030)$",
        "hgt" to "^(((1[5-8][0-9]|19[0-3])cm)|((59|6[0-9]|7[0-6])in)){1}$",
        "hcl" to "^#[0-9a-f]{6}$",
        "ecl" to "^((amb)|(blu)|(brn)|(gry)|(grn)|(hzl)|(oth)){1}$",
        "pid" to "^\\d{9}$",
        "cid" to ".*",
    )

    override fun entryHasValidKey(index: Int, key: String): Boolean {
        batchEntries[index].split(" ").forEach {
            val splitValue = it.split(":")
            if (!Regex(rules[splitValue[0]].toString()).containsMatchIn(splitValue[1])) {
                return false
            }
        }
        return super.entryHasValidKey(index, key)
    }
}