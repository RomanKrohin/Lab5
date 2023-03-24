package WorkModuls

import StudyGroupInformation.StudyGroup
/**
 * Класс проверки правильности введенных данных
 */
class CheckModule {

    /**
     * Метод проверки
     * @param studyGroup
     * @return Boolean
     */
    fun check(studyGroup: StudyGroup): Boolean {
        if ((studyGroup.getAdmin().getName().length > 0) and (studyGroup.getAdmin().getWeight() > 0)) {
            if ((studyGroup.getName().length > 0) and (studyGroup.getStudentcount() > 0) and (studyGroup.getShouldBeExpelled() > 0) and (studyGroup.getAverageMark() > 0) and (studyGroup.getCoordinates()
                    .getX() < 42) and (studyGroup.getCoordinates().getY() > -612)
            ) {
                return true
            } else {
                return false
            }
        } else {
            return false
        }
    }
}