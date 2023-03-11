package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer

class CommandHistory(workCollection: Collections.Collection<String, StudyGroup>) : Command() {
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
        val answer= Answer()
        try {
            //Вывод массива команды, которые были вложены в массив
            answer.setterResult(key)
        }
        catch (e: CommandException){
            throw e
        }
    return answer
    }

}