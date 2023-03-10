package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import java.util.*

class CommandRemove: Command(), ActionsWithCollection {
    /**
     * Класс команды, которая удаляет объект из коллекции по его ключу
     */

    //Команда удаляет объект из коллекции по его ключу
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collection<String, StudyGroup>, key: String) {
        try {
            executeRemove(collection, key.uppercase(Locale.getDefault()))
        }
        catch (e: CommandException){
            throw e
        }
    }
    //Интерфейсы для работы с коллекцией
    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.collection.put(key, studyGroup)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.collection.remove(key)
    }
    //
}