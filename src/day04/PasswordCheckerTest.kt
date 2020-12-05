package day04

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PasswordCheckerTest {
    lateinit var passportChecker: PassportChecker

    @BeforeEach
    fun setup() {
        passportChecker = PassportChecker("resources/day04/input-test.txt")
        passportChecker.formatBatch()
    }

    @Test
    fun formatHaveCorrectNumberOfInput() {
        assertEquals(4, passportChecker.batchEntries.size)
    }

    @Test
    fun formatHaveCorrectOutput() {
        assertEquals(
            "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm",
            passportChecker.batchEntries[0]
        )
    }

    @Test
    fun validateHasKey() {
        assertTrue(passportChecker.entryHasValidKey(0, "ecl"))
    }

    @Test
    fun validateHasNotKey() {
        assertFalse(passportChecker.entryHasValidKey(0, "xxx"))
    }

    @Test
    fun validateHasAllKey() {
        assertTrue(passportChecker.validateEntry(0))
    }

    @Test
    fun validateHasNotAllKey() {
        assertFalse(passportChecker.validateEntry(1))
    }

    @Test
    fun validateBatch() {
        assertEquals(2, passportChecker.validate())
    }
}
