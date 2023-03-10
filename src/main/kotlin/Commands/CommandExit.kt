package Commands

import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import kotlin.system.exitProcess

class CommandExit: Command() {
    /**
     * Класс команды, которая заканчивает работу приложения
     */

    //Команды заканчивает работу приложения
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            exitProcess(0)
        }
        catch (e: CommandException){
            throw e
        }
    }

}