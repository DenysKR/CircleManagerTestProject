package model

data class Circle(val id: Int, val name: String = "", val members: MutableList<Member> = mutableListOf<Member>())

