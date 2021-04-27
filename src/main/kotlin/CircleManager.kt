import model.Circle
import model.Member
import utils.Logger

class CircleManager {

    private val circles by lazy { mutableListOf<Circle>() }

    @Synchronized
    fun createAndAddCircle(id: Int, name: String = "", members: MutableList<Member> = mutableListOf<Member>()) {
        val circle = Circle(id, name = name, members = members)
        circles.add(circle)
        Logger.log("Circles list after adding new element: $circles")

    }

    @Synchronized
    fun deleteCircle(id: Int) {
        circles.removeIf { it.id == id }
        Logger.log("Circles list after deletion: $circles")
    }

    @Synchronized
    fun queryCirclesByMemberCount(count: Int) {
        val filtered = circles.filter { it.members.size == count }
        Logger.log("Circles list after query execution: $filtered")
    }

    @Synchronized
    fun addMemberToCircle(circleId: Int, member: Member) {
        if (circles.isNotEmpty()) {
            val filtered = circles.findLast { it.id == circleId }
            filtered?.members?.add(member)
        } else {
            createAndAddCircle(circleId, members = mutableListOf(member))
        }
        Logger.log("Circles list after new member adding: $circles")
    }

    @Synchronized
    fun printCirclesList() {
        Logger.log("Circles list: $circles")
    }
}