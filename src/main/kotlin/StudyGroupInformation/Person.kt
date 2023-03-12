package StudyGroupInformation

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    private val name: String,
    private val weight: Int,
    private val color: Color,
    private val country: Country,
) {
    fun getName(): String {
        return name
    }

    fun getWeight(): Int {
        return weight
    }

}