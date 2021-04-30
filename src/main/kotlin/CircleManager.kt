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

    @Synchronized
    fun removeMemberById(circleId: Int, member: Member) {
        if (circles.isNotEmpty()) {
            val filtered = circles.findLast { it.id == circleId }
            filtered?.members?.let {
                with(it) {
                    remove(member)
                    if (isEmpty())
                        circles.remove(filtered)
                }
            }
        }
        Logger.log("Circles list after member removing: $circles")
    }

    @Synchronized
    fun duplicatesCount() {
        var duplicatesCounter = 0
        var i = 0

        while (i < circles.size) {
            var circle = circles[i]
            var j = i
            var duplicatesCounterInner = 0

            while (j < circles.size) {
                var nextCircle = circles[j]

                if (circle == nextCircle) {
                    duplicatesCounterInner++
                }

                if (duplicatesCounterInner > duplicatesCounter)
                    duplicatesCounter = duplicatesCounterInner
                j++
            }
            i++
        }
        Logger.log("Duplicates count: $duplicatesCounter")
    }

    @Synchronized
    fun removeDuplicates() {
        val result = mutableListOf<Circle>().apply { addAll(circles) }

        var i = 0

        while (i < circles.size) {
            var circle = circles[i]
            var j = i + 1

            while (j < circles.size) {
                var nextCircle = circles[j]

                if (circle.id == nextCircle.id) {
                    when (true) {
                        circle.members.size < nextCircle.members.size -> result.remove(circle)
                        circle.members.size > nextCircle.members.size -> result.remove(nextCircle)
                        else -> result.remove(nextCircle)
                    }
                }
                j++
            }
            i++
        }
        Logger.log("Remove duplicates result: $result")
    }
}