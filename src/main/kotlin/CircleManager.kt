import model.Circle
import model.Member

class CircleManager {

    private val circles by lazy { mutableListOf<Circle>() }

    @Synchronized
    fun createAndAddCircle(id: Int, name: String = "", members: MutableList<Member> = mutableListOf<Member>()) {
        val circle = Circle(id, name = name, members = members)
        circles.add(circle)
        print("Circles list after adding new element: $circles")
        println()

    }

    @Synchronized
    fun deleteCircle(id: Int) {
        circles.removeIf { it.id == id }
        print("Circles list after deletion: $circles")
        println()
    }

    @Synchronized
    fun queryCirclesByMemberCount(count: Int) {
        val filtered = circles.filter { it.members.size == count }
        print("Circles list after quering: $filtered")
        println()
    }

    @Synchronized
    fun addMemberToCircle(circleId: Int, member: Member) {
        if (circles.isNotEmpty()) {
            val filtered = circles.findLast { it.id == circleId }
            filtered?.members?.add(member)
        } else {
            createAndAddCircle(circleId, members = mutableListOf(member))
        }

        print("Circles list after new member adding: $circles")
        println()
    }


}