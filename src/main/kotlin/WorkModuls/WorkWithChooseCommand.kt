package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

interface WorkWithChooseCommand {
    fun createChooseCommand(collection: Collection<String, StudyGroup>, history: MutableList<String>): ChooseCommand
}