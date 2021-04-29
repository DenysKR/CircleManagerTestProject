package model

data class Circle(val id: Int, val name: String = "", val members: MutableList<Member> = mutableListOf<Member>()){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Circle

        if (id != other.id) return false
        if (name != other.name) return false
        if (members != other.members) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + members.hashCode()
        return result
    }
}
