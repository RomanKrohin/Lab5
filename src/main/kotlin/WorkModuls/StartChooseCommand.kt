package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

/**
 * Класс начала выборки команды
 */
interface StartChooseCommand {

    /**
     * Метод инициализации выборки команды
     */
    fun startChooseCommand(collection: Collection<String, StudyGroup>, path: String)
}