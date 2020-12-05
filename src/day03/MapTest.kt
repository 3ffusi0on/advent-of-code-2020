package day03

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MapTest {
    lateinit var map: Map

    @BeforeEach
    fun setup() {
        map = Map("resources/day03/input.txt")
    }

    @Test
    fun isTreeFalseWhenNoTree() {
        assertFalse(map.isTree(0, 0))
    }

    @Test
    fun isTreeTrueWhenTree() {
        assertTrue(map.isTree(4, 0))
    }

    @Test
    fun mapCellIsCorrect() {
        assertEquals('.', map.getCell(0, 0))
        assertEquals('#', map.getCell(4, 0))
    }

    @Test
    fun mapIsRedundant() {
        val x = 4
        assertEquals(
            map.getCell(x, 0),
            map.getCell(map.length + x, 0)
        )
    }

    @Test
    fun isValidWhenInsideOfMap() {
        assertTrue(map.isValid(1))
    }

    @Test
    fun isNotValidWhenOutsideOfMap() {
        assertFalse(map.isValid(map.height + 1))
    }

    @Test
    fun slope_1_3() {
        assertEquals(218, map.countTreesForSlope(3, 1))
    }
}