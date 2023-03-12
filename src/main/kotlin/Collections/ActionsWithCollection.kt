package Collections

import StudyGroupInformation.StudyGroup

/**
 * Интерфейс инициализации действий с коллекцией
 * @property Collection
 */
interface ActionsWithCollection {

    /**
     * Метод инициализации добавления элемента
     * @param collection
     * @param studyGroup
     * @param key
     */
    fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String)

    /**
     * Метод инициализации удаления элемента
     * @param collection
     * @param key
     */
    fun executeRemove(collection: Collection<String, StudyGroup>, key: String)
}