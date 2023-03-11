package Commands

import Exceptions.CommandException
import WorkModuls.Answer
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
    override fun commandDo(key: String) : Answer{
        val answer= Answer()
        try {
            exitProcess(0)
        }
        catch (e: CommandException){
            throw e
        }
        return answer
    }

}