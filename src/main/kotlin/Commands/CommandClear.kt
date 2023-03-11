package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer

class CommandClear(workCollection: Collection<String, StudyGroup>) : Command(), ActionsWithCollection, WorkWithAnswer {
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
        try {
            val answer=createReversedAnswer()
            //Цикл выдергивает объекты по их ключам
            val listOfKeys= collection.collection.keys()
            for (i in listOfKeys){
                executeRemove(collection, i)
                collection.collection.keys.clear()
            }
            return answer
        }
        catch (e: CommandException){
            throw e
        }
    }

    override fun executeAdd(collection: Collections.Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collections.Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Clear")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }
}