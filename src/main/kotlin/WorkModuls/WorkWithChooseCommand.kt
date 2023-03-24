package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

/**
 * Интерфейс для работы с классом выборки команд
 */
interface WorkWithChooseCommand {

    /**
     * Метод для создания экземпляра класса выборки команд
     * @param collection
     * @param history
     * @param pathOfFile
     * @param pathsForExecuteScripts
     */
    fun createChooseCommand(
        collection: Collection<String, StudyGroup>,
        history: MutableList<String>,
        pathsForExecuteScripts: MutableList<String>,
        pathOfFile: String,
    ): ChooseCommand
}