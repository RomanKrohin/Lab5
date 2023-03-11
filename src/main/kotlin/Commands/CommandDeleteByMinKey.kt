package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import java.util.*

class CommandDeleteByMinKey(workCollection: Collection<String, StudyGroup>): Command(), ActionsWithCollection {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection

    }
    /**
     * Класс, команды, которая удаляет объекты значение ключа которых меньше чем у заданного
     */
    //Команда удаляет объекты значение ключа которых меньше чем у заданного

    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        val answer= Answer()
        try {
            //Цикл проходиться по коллекции, сравнивает и удаляет подходящие объекты
            if (collection.collection.keys.contains(key.uppercase(Locale.getDefault()))){
                for (i in collection.collection.keys){
                    if (key.uppercase(Locale.getDefault()).hashCode()>i.hashCode()){
                        executeRemove(collection, i)
                    }
                }
            }
        }
        catch (e: CommandException){
            throw e
        }
        return answer
    }

    //Интерфейсы для работы с коллекцией
    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
    //
}