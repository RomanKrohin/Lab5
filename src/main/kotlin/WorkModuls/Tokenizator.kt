package WorkModuls

import Commands.ChangeLine

class Tokenizator: ChangeLine {

    //Инициализация массива истории команд(Туда сохраняются команды)
    private val history = listOf<String>().toMutableList()

    fun tokenizateCommand(command: String, path: String, history: MutableList<String>): MutableList<String>{
            //Нормализация компонент команды(массив в котором хранятся название команды и ее аргумент)
            val commandComponent = returnCommandComponents(command, path, history)
            return commandComponent

    }

    override fun returnCommandComponents(command: String, path: String, history: MutableList<String>): MutableList<String> {
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


}
