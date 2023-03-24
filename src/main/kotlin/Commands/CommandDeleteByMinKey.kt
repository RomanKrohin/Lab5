package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer
import java.util.*

/**
 * Класс, команды, которая удаляет объекты значение ключа которых меньше чем у заданного
 */
class CommandDeleteByMinKey(workCollection: Collection<String, StudyGroup>) : Command(), ActionsWithCollection,
    WorkWithAnswer {
    var collection: Collection<String, StudyGroup>

    init {
        collection = workCollection

    }

    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            val answer = createReversedAnswer()
            val listOfKeys = collection.collection.keys
            val listOfKeysForDelete = listOf<String>().toMutableList()
            if (collection.collection.keys.contains(key.uppercase(Locale.getDefault()))) {
                for (i in listOfKeys) {
                    if (key.uppercase(Locale.getDefault()).hashCode() > i.hashCode()) {
                        listOfKeysForDelete.add(i)
                    }
                }
                for (i in listOfKeysForDelete) {
                    executeRemove(collection, i)
                }
            }
            return answer
        } catch (e: CommandException) {
            return createAnswer()
        }
    }

    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Delete by minimum key")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }
}