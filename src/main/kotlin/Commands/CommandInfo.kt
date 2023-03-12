package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer

/**
 * Класс команды, которая выводит информацию о коллекции
 */
class CommandInfo(workCollection: Collection<String, StudyGroup>) : Command(), WorkWithAnswer {

    var collection: Collection<String, StudyGroup>
    var key: String = null.toString()

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
            answer.setterResult("Collection: HashTable\n" + "Size " + collection.collection.size + "\n" + java.time.LocalTime.now())
            return answer
        } catch (e: CommandException) {
            return createAnswer()
        }
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Info")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

}