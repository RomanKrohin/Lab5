package Commands

import Exceptions.CommandException
import StudyGroupInformation.StudyGroup

class CommandInfo: Command(){
    /**
     * Класс команды, которая выводит информацию о коллекции
     */
    //Команда выводит информацию и коллекции
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            println("Collection: HashTable\n"+"Size "+collection.collection.size+"\n"+java.time.LocalTime.now())
        }
        catch (e: CommandException){
            throw e
        }
    }

}