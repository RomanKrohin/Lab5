package StudyGroupInformation

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class StudyGroup(
    private val name: String = "",
    private val coordinates: Coordinates,
    private val studentCount: Long,
    private val shouldBeExpelled: Int,
    private val averageMark: Int,
    private val formOfEducation: FormOfEducation? = null,
    private val groupAdmin: Person,
) {

    private val localDateTime: LocalDateTime by lazy { java.time.LocalDateTime.now() }
    private var id: Long = 0
    fun setId(_id: Long) {
        id = _id
    }

    fun getId(): Long {
        return id
    }

    fun getName(): String {
        return name
    }

    fun getCoordinates(): Coordinates {
        return coordinates
    }

    fun getStudentcount(): Long {
        return studentCount
    }

    fun getShouldBeExpelled(): Int {
        return shouldBeExpelled
    }

    fun getAverageMark(): Int {
        return averageMark
    }

    fun getFormOfEducation(): FormOfEducation? {
        return formOfEducation
    }

    fun getAdmin(): Person {
        return groupAdmin
    }
}