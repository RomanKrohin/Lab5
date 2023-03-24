package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

/**
 * Интерфейс для работы модулем чтения файла
 */
interface ExecuteActionsWithRead {

    /**
     * Метод начала чтения
     * @param readFile
     * @param collection
     */
    fun executeRead(readFile: ReadFile, collection: Collection<String, StudyGroup>)

    /**
     * Метод создания модуля чтения
     * @param path
     * @return ReadFile
     */
    fun createReader(path: String): ReadFile
}