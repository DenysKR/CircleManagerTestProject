import model.Circle
import model.Member
import java.util.concurrent.atomic.AtomicInteger

class CircleManager {

    private val circles by lazy { mutableListOf<Circle>() }
    private var mostRecentId: AtomicInteger = AtomicInteger(0)

    @Synchronized
    fun createAndAddCircle(name: String = "", members: MutableList<Member> = mutableListOf<Member>()) {
        mostRecentId.incrementAndGet()
        val circle = Circle(mostRecentId.get(), name = name, members = members)
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


}