package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import java.util.*

class CommandRemove(workCollection: Collection<String, StudyGroup>): Command(), ActionsWithCollection {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection
    }
    /**
     * Класс команды, которая удаляет объект из коллекции по его ключу
     */

    //Команда удаляет объект из коллекции по его ключу
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        val answer= Answer()
        try {
            executeRemove(collection, key.uppercase(Locale.getDefault()))
        }
        catch (e: CommandException){
            throw e
        }
        return answer
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