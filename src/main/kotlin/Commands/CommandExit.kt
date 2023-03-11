package Commands

import Exceptions.CommandException
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer
import kotlin.system.exitProcess

class CommandExit: Command(), WorkWithAnswer {
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
        try {
            exitProcess(0)
        }
        catch (e: CommandException){
            return createAnswer()
        }
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Exit")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

}