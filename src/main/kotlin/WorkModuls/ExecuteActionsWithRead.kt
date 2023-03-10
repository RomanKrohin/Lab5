package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

interface ExecuteActionsWithRead {
    /**
     * Интерфейс для работы модулем чтения файла
     */

    /**
     * Метод начала чтения
     * @param readFile
     * @param collection
     */
    public fun executeRead(readFile: ReadFile, collection: Collection<String, StudyGroup>)

    /**
     * Метод создания модуля чтения
     * @param path
     * @return ReadFile
     */
    public fun createReader(path: String): ReadFile
}