package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

interface StartChooseCommand {
    /**
     * Класс начала выборки команды
     */

    /**
     * Метод инициализации выборки команды
     */
    fun startChooseCommand(collection: Collection<String, StudyGroup>, path: String)
}