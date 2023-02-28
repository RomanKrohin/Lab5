package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

interface ExecuteActionsWithRead {
    public fun executeRead(readFile: ReadFile, collection: Collection<String, StudyGroup>)
    public fun createReader(path: String): ReadFile
}