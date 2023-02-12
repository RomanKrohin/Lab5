import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
class StudyGroup (private val name: String,private val coordinates: Coordinates,private val studentCount: Int,private val shouldBeExpelled: Int,private val averageMark: Int,private val formOfEducation: FormOfEducation, private val groupAdmin: Person) {

    private val localDateTime:LocalDateTime by lazy { java.time.LocalDateTime.now() }
    private var id: Int = 0
    fun set_id(_id: Int){
        id=_id
    }
}