package StudyGroupInformation

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(private val x: Long, private val y: Long) {
    fun getX(): Long {
        return x
    }

    fun getY(): Long {
        return y
    }
}