import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
class StudyGroup(private val name: String="", private val coordinates: Coordinates, private val studentCount: Int, private val shouldBeExpelled: Int? = null, private val averageMark: Int? = null, private val formOfEducation: FormOfEducation, private val groupAdmin: Person) {

    private val localDateTime:LocalDateTime by lazy { java.time.LocalDateTime.now() }
    private var id: Int = 0
    fun set_id(_id: Int){
        id=_id
    }
    fun get_name(): String{
        return name
    }
    fun get_coordinates(): Coordinates{
        return coordinates
    }
    fun get_studentcount(): Int{
        return studentCount
    }
    fun get_shouldBeExpelled(): Int?{
        return shouldBeExpelled
    }
    fun get_averageMark(): Int?{
        return averageMark
    }
    fun get_formOfEducation(): FormOfEducation{
        return formOfEducation
    }
    fun get_admin(): Person{
        return groupAdmin
    }
}