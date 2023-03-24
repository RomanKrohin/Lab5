package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

/**
 * Интерфейс создания коллекции
 */
interface CreateCollection {

    /**
     * Меетод создания коллекции
     * @return Collection
     */
    fun createCollection(): Collection<String, StudyGroup>
}