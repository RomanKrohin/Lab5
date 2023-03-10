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
    public fun createCollection(): Collection<String, StudyGroup>
}