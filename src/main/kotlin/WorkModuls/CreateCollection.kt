package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

interface CreateCollection {
    /**
     * Интерфейс создания коллекции
     */

    /**
     * Меетод создания коллекции
     * @return Collection
     */
    fun createCollection(): Collection<String, StudyGroup>
}