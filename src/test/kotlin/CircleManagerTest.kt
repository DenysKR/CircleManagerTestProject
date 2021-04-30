import model.Member
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CircleManagerTest {

    lateinit var circleManager: CircleManager

    @BeforeEach
    fun setUp() {
        circleManager = CircleManager()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun createAndAddCircle() {
        val circle = circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(1)))
        assertTrue(circleManager.circles.contains(circle))
    }

    @Test
    fun deleteCircle() {
        val candidateForRemoving = Member(1)
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(candidateForRemoving, Member(2)))
        circleManager.deleteCircle(1)
        assertFalse(circleManager.circles.contains(candidateForRemoving))
    }

    @Test
    fun queryCirclesByMemberCount() {
    }

    @Test
    fun addMemberToCircle() {
    }

    @Test
    fun printCirclesList() {
    }

    @Test
    fun removeMemberById() {
    }

    @Test
    fun duplicatesCount() {
    }

    @Test
    fun removeDuplicates() {
    }
}