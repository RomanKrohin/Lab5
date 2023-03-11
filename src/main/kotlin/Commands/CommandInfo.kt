package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer

class CommandInfo(workCollection: Collections.Collection<String, StudyGroup>): Command(){

    var collection: Collection<String, StudyGroup>
    var key: String = null.toString()
    init {
        collection=workCollection

    }
    /**
     * Класс команды, которая выводит информацию о коллекции
     */
    //Команда выводит информацию и коллекции
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        val answer= Answer()
        try {
            answer.setterResult("Collection: HashTable\n"+"Size "+collection.collection.size+"\n"+java.time.LocalTime.now())
        }
        catch (e: CommandException){
            throw e
        }
        return answer
    }

}