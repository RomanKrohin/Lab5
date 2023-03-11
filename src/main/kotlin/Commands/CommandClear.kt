package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer

class CommandClear(workCollection: Collections.Collection<String, StudyGroup>) : Command(), ActionsWithCollection {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection
    }
    /**
     * Класс команды очищающая коллекцию
     */

    //Команда очищающая колекцию
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        val answer= Answer()
        try {
            //Цикл выдергивает объекты по их ключам
            val listOfKeys= collection.collection.keys()
            for (i in listOfKeys){
                executeRemove(collection, i)
            }
        }
        catch (e: CommandException){
            throw e
        }
        return answer
    }

    override fun executeAdd(collection: Collections.Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collections.Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
}