package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

interface StartChooseCommand {
    fun startChooseCommand(collection: Collection<String, StudyGroup>, path: String)
}