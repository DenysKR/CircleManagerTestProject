import model.Member

fun main(args: Array<String>) {
    println("Hello World!")
    val m = CircleManager()
    m.createAndAddCircle("Circle 1", members = mutableListOf(Member(1), ))
    m.createAndAddCircle("Circle 2", members = mutableListOf(Member(1), Member(2)))
    m.createAndAddCircle("Circle 3", members = mutableListOf(Member(1), Member(2), Member(3)))
    m.createAndAddCircle("Circle 4", members = mutableListOf(Member(1), Member(2), Member(3), Member(4)))

    m.queryCirclesByMemberCount(2)
}