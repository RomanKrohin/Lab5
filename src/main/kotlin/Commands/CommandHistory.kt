package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer

class CommandHistory(workCollection: Collection<String, StudyGroup>) : Command(), WorkWithAnswer {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection
    }
    /**
     * Класс команды, который выводит последние 12 введенных команд
     */

    //Команда, которая выводит последние 12 команд
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            val answer= createReversedAnswer()
            //Вывод массива команды, которые были вложены в массив
            answer.setterResult(key)
            return answer
        }
        catch (e: CommandException){
            return createAnswer()
        }
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "History")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

}