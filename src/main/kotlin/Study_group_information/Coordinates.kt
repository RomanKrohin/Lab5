package Study_group_information

import kotlinx.serialization.Serializable

@Serializable
class Coordinates (private val x: Long, private val y:Long)  {
    fun get_x(): Long{
        return x
    }
    fun get_y(): Long{
        return y
    }
}