package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

interface ExportTokens {
    fun exportTokens(collection: Collection<String, StudyGroup>, commandComponent: MutableList<String>)
}