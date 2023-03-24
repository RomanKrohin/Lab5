package WorkModuls

import Commands.Command
import StudyGroupInformation.StudyGroup

/**
 * Интерфейс для создания массива с командами
 */

interface CreateCommand {
    /**
     * Метод для создания массива команд
     * @return Map<String, Command>
     */
    fun createCommnads(
        collection: Collections.Collection<String, StudyGroup>,
        history: MutableList<String>,
        pathsForExecuteScripts: MutableList<String>,
        pathOfFile: String,
    ): Map<String, Command>
}