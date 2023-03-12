package WorkModuls

import Commands.Command
import StudyGroupInformation.StudyGroup

interface CreateCommand {
    /**
     * Интерфейс для создания массива с командыми
     */

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