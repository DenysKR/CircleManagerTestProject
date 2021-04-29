import model.Member

fun main(args: Array<String>) {
    val m = CircleManager()

    m.createAndAddCircle(id=1,"Circle 1", members = mutableListOf(Member(1), ))
    m.createAndAddCircle(id=1,"Circle 1", members = mutableListOf(Member(1), ))
    m.createAndAddCircle(id=1,"Circle 1", members = mutableListOf(Member(1), ))
    m.createAndAddCircle(id=3,"Circle 3", members = mutableListOf(Member(1), Member(2), Member(3)))
    m.createAndAddCircle(id=3,"Circle 3", members = mutableListOf(Member(1), Member(2), Member(3)))

//    m.printCirclesList()
    m.duplicatesCount()
}