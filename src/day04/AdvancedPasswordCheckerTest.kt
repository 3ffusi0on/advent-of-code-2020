package day04

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AdvancedPasswordCheckerTest {
    @Test
    fun validateOnlyInvalidBatch() {
        val passportChecker = AdvancedPassportChecker("resources/day04/input-test-advanced-invalid.txt")
        passportChecker.formatBatch()
        assertEquals(0, passportChecker.validate())
    }

    @Test
    fun validateOnlyValidBatch() {
        val passportChecker = AdvancedPassportChecker("resources/day04/input-test-advanced-valid.txt")
        passportChecker.formatBatch()
        assertEquals(4, passportChecker.validate())
    }
}
