package Commands

import Exceptions.CommandException
import StudyGroupInformation.StudyGroup

class CommandHistory : Command() {
    /**
     * Класс команды, который выводит последние 12 введенных команд
     */

    //Команда, которая выводит последние 12 команд
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            //Вывод массива команды, которые были вложены в массив
            println(key)
        }
        catch (e: CommandException){
            throw e
        }

    }

}