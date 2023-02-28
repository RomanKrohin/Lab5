package Collections

import StudyGroupInformation.StudyGroup

interface ActionsWithCollection {
    fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String, )
    fun executeRemove(collection: Collection<String, StudyGroup>, key: String)
}