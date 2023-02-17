import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
class StudyGroup(private val name: String="", private val coordinates: Coordinates, private val studentCount: Long, private val shouldBeExpelled: Int, private val averageMark: Int, private val formOfEducation: FormOfEducation? = null, private val groupAdmin: Person) {

    private val localDateTime:LocalDateTime by lazy { java.time.LocalDateTime.now() }
    private var id: Long = 0
    fun set_id(_id: Long){
        id=_id
    }
    fun get_id(): Long{
        return id
    }
    fun get_name(): String{
        return name
    }
    fun get_coordinates(): Coordinates{
        return coordinates
    }
    fun get_studentcount(): Long{
        return studentCount
    }
    fun get_shouldBeExpelled(): Int{
        return shouldBeExpelled
    }
    fun get_averageMark(): Int{
        return averageMark
    }
    fun get_formOfEducation(): FormOfEducation? {
        return formOfEducation
    }
    fun get_admin(): Person{
        return groupAdmin
    }
}