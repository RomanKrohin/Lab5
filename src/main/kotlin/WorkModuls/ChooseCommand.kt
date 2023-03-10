package WorkModuls

import Collections.Collection
import Commands.*
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import java.util.*

class ChooseCommand : CreateCommand, ChangeLine, WorkWothHistory {

    /**
     * Класс выборки команды, здесь команды обрабатываются и выбирается
     * подходящие
     * @param history
     * @param listOfCommand
     */
    //Инициализация массива истории команд(Туда сохраняются команды)
    val history = listOf<String>().toMutableList()

    //Инициализация map в котором храняться экземпляры команды (ключами выступают их названия)
    val listOfCommand = createCommnads()

    //Метод выборки команды
    /**
     * Метод выборки команды
     * @param collection
     * @param path
     */
    fun chooseCoomand(collection: Collection<String, StudyGroup>, path: String) {
        //Чтение команды из потока ввода будет происходить до команды exit
        while (true) {
            try {
                val coomand = readln().lowercase(Locale.getDefault())
                //Работа и истоией (запоминаем команды)
                workWithArrayHistory(history, coomand)
                //Нормализация компонент команды(массив в котором храняться название команды и ее аргумент)
                val commandComponent = returnCommandComponents(coomand, path)
                //Вызов метода работы команды
                listOfCommand.get(commandComponent[0])?.commandDo(collection, commandComponent[1])
            } catch (e: CommandException) {
                throw e
            }

        }
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

    override fun createCommnads(): Map<String, Command> {
        return mapOf<String, Command>(
            "show" to CommandShow(),
            "update id" to ComandUpdateId(),
            "save" to CommandSave(),
            "history" to CommandHistory(),
            "help" to CommandHelp(),
            "exit" to CommandExit(),
            "info" to CommandInfo(),
            "clear" to CommandClear(),
            "max_by_name" to CommandMaxName(),
            "print_field_descending_average_mark" to CommandPrintFieldDescendingAverageMark(),
            "remove_greater_key" to CommandDeleteByMaxKey(),
            "remove_lower_key" to CommandDeleteByMinKey(),
            "count_less_than_group_admin" to CommandCountLessThanAdmin(),
            "insert" to CommandInsert(),
            "remove" to CommandRemove(),
            "execute_script" to CommandExecuteScript()
        )
    }
}