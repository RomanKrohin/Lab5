package WorkModuls

import Collections.Collection
import Commands.*
import StudyGroupInformation.StudyGroup
import java.util.*

class ChooseCommand(collection: Collection<String, StudyGroup>, history: MutableList<String>) : CreateCommand, WorkWithAnswer {
    val listOfCommand= createCommnads(collection, history)

    /**
     * Класс выборки команды, здесь команды обрабатываются и выбирается
     * подходящие
     * @param history
     * @param listOfCommand
     */
    //Инициализация массива истории команд(Туда сохраняются команды)

    //Инициализация map в котором храняться экземпляры команды (ключами выступают их названия)

    //Метод выборки команды
    /**
     * Метод выборки команды
     * @param collection
     * @param path
     */
    fun chooseCoomand(commandComponent: MutableList<String>): Answer {
        //Чтение команды из потока ввода будет происходить до команды exit
                //Вызов метода работы команды4
                val command = listOfCommand[commandComponent[0]]?.let {
                    val answer=it.commandDo(commandComponent[1])
                    return answer
                }
        return createAnswer()
    }


    override fun createCommnads(collection: Collection<String, StudyGroup>, history: MutableList<String>): Map<String, Command> {
        return mapOf<String, Command>(
            "show" to CommandShow(collection),
            "update id" to ComandUpdateId(collection),
            "save" to CommandSave(collection),
            "history" to CommandHistory(collection),
            "help" to CommandHelp(),
            "exit" to CommandExit(),
            "info" to CommandInfo(collection),
            "clear" to CommandClear(collection),
            "max_by_name" to CommandMaxName(collection),
            "print_field_descending_average_mark" to CommandPrintFieldDescendingAverageMark(collection),
            "remove_greater_key" to CommandDeleteByMaxKey(collection),
            "remove_lower_key" to CommandDeleteByMinKey(collection),
            "count_less_than_group_admin" to CommandCountLessThanAdmin(collection),
            "insert" to CommandInsert(collection),
            "remove" to CommandRemove(collection),
            "execute_script" to CommandExecuteScript(collection, history)
        )
    }

    override fun createAnswer(): Answer {
        return Answer()
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }
}