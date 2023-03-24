package WorkModuls

import StudyGroupInformation.*
import org.junit.jupiter.api.Test

class CheckModuleTest {

    @Test
    fun testCheck() {
        val checkModuleTest= CheckModule()
        val studyGroup= StudyGroup("123", Coordinates(1, 2), 1, 2, 3, FormOfEducation.DISTANCE_EDUCATION, Person("123",1,Color.RED, Country.INDIA))
        studyGroup.setId(1)
        assert(checkModuleTest.check(studyGroup))
    }
}