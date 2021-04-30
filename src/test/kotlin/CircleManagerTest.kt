import model.Member
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CircleManagerTest {

    lateinit var circleManager: CircleManager

    @BeforeEach
    fun setUp() {
        circleManager = CircleManager()
    }

    @Test
    fun createAndAddCircle() {
        val circle = circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(1)))

        assertTrue(circleManager.circles.contains(circle))
    }

    @Test
    fun deleteCircle() {
        val circle = circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(2)))
        circleManager.deleteCircle(1)

        assertFalse(circleManager.circles.contains(circle))
    }

    @Test
    fun queryCirclesByMemberCount() {
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(1), Member(2)))
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(1), Member(2)))
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(1), Member(2)))
        val queryResult = circleManager.queryCirclesByMemberCount(2)

        assertEquals(3, queryResult)
    }

    @Test
    fun addMemberToCircle() {
        val candidateForAdding = Member(3)
        val addedCircle = circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(1), Member(2)))
        circleManager.addMemberToCircle(addedCircle.id, candidateForAdding)

        assertTrue(addedCircle.members.contains(candidateForAdding))
    }

    @Test
    fun removeMemberById() {
        val candidateForRemoving = Member(3)
        val circle = circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(candidateForRemoving, Member(2)))
        circleManager.removeMemberById(circle.id, candidateForRemoving)

        assertFalse(circle.members.contains(candidateForRemoving))
    }

    @Test
    fun removeMemberByIdFromSingleElementCirclesList() {
        val candidateForRemoving = Member(3)
        val circle = circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(candidateForRemoving))
        circleManager.removeMemberById(circle.id, candidateForRemoving)

        assertFalse(circleManager.circles.contains(candidateForRemoving))
    }

    @Test
    fun duplicatesCount() {
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(3)))
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(3)))
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(3)))

        assertEquals(3, circleManager.duplicatesCount())
    }

    @Test
    fun removeDuplicates() {
        circleManager.createAndAddCircle(2, "Circle 2", mutableListOf(Member(3)))
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(3)))
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(3)))
        circleManager.createAndAddCircle(1, "Circle 1", mutableListOf(Member(3)))
        circleManager.removeDuplicates()

        assertEquals(1, circleManager.circles.size)
    }
}