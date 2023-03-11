package WorkModuls

import Collections.Collection
import Commands.*
import StudyGroupInformation.StudyGroup
import java.util.*

class ChooseCommand(collection: Collection<String, StudyGroup>) : CreateCommand, ChangeLine, WorkWothHistory {
    val listOfCommand= createCommnads(collection)

    /**
     * Класс выборки команды, здесь команды обрабатываются и выбирается
     * подходящие
     * @param history
     * @param listOfCommand
     */
    //Инициализация массива истории команд(Туда сохраняются команды)
    private val history = listOf<String>().toMutableList()

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
                val command = listOfCommand[commandComponent[0]]
                val answer= listOfCommand.get(commandComponent[0])?.commandDo(commandComponent[1])
                return answer!!

    }


    //Блок нормализации команд
    override fun returnCommandComponents(command: String, path: String): MutableList<String> {
        //Делим по пробелам и помещаем в массив
        val commandComponent1 = command.split(" ").toMutableList()
        //Создание буферного массива
        val commandComponent2: MutableList<String> = listOf<String>().toMutableList()
        //Очистка от нулевых строк
        for (i in commandComponent1) {
            if (!(i.equals(""))) commandComponent2.add(i)
        }
        //Добавление компоненты для работы команды history
        if (commandComponent2[0].equals("history")) {
            commandComponent2.add(history.toString())
        }
        //Добавление компоненты для работы команды save
        if (commandComponent2[0].equals("save")) {
            commandComponent2.add(path)
        }
        //Добавление компоненты для работы команды execute_script
        if (commandComponent2[0].equals("execute_script")) {
            commandComponent2[1] = commandComponent2[1] + " " + path
        }
        //Исправление команды состоящих из двух слов
        if (commandComponent2.size == 3) {
            commandComponent2[0] = commandComponent2[0] + " " + commandComponent2[1]
            commandComponent2[1] = commandComponent2[2]
            commandComponent2.removeAt(2)
        }
        //Служебное исправление команды состоящих из одного слова
        if (commandComponent2.size == 1) {
            commandComponent2.add("")
        }
        return commandComponent2
    }

    //Работа с историей команд, запоминаем последние 12 команд
    override fun workWithArrayHistory(array: MutableList<String>, coomand: String) {
        if (array.size > 12) {
            array.removeAt(0)
            array.add(coomand)
        } else {
            array.add(coomand)
        }
    }

    override fun createCommnads(collection: Collection<String, StudyGroup>): Map<String, Command> {
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
            "execute_script" to CommandExecuteScript(collection)
        )
    }
}