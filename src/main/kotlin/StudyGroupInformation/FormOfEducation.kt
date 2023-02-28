package StudyGroupInformation

import kotlinx.serialization.Serializable

@Serializable
enum class FormOfEducation {
    DISTANCE_EDUCATION,
    FULL_TIME_EDUCATION,
    EVENING_CLASSES,
}