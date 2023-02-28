package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

interface CreateCollection {
    public fun createCollection(): Collection<String, StudyGroup>
}