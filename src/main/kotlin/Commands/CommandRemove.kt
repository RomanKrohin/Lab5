package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer
import java.util.*

/**
 * Класс команды, которая удаляет объект из коллекции по его ключу
 */

class CommandRemove(workCollection: Collection<String, StudyGroup>) : Command(), ActionsWithCollection, WorkWithAnswer {
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
            var answer = createReversedAnswer()
            executeRemove(collection, key.uppercase(Locale.getDefault()))
            return answer
        } catch (e: CommandException) {
            return createAnswer()
        }
    }

    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.collection.put(key, studyGroup)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.collection.remove(key)
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Remove by key")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }
}