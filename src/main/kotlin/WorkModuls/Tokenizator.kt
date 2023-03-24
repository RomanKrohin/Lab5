package WorkModuls

import Commands.ChangeLine

/**
 * Класс для токенизации команд
 */
class Tokenizator : ChangeLine {

    private val history = listOf<String>().toMutableList()

    /**
     * Метод для токенизации команд
     * @param command
     * @param path
     * @param history
     * @return MutableList<String>
     */
    fun tokenizateCommand(command: String, path: String, history: MutableList<String>): MutableList<String> {
        val commandComponent = returnCommandComponents(command, path, history)
        return commandComponent

    }

    override fun returnCommandComponents(
        command: String,
        path: String,
        history: MutableList<String>,
    ): MutableList<String> {
        val commandComponent1 = command.split(" ").toMutableList()
        val commandComponent2: MutableList<String> = listOf<String>().toMutableList()
        for (i in commandComponent1) {
            if (!(i.equals(""))) commandComponent2.add(i)
        }
        if (commandComponent2[0].equals("history")) {
            commandComponent2.add(history.toString())
        }
        if (commandComponent2[0].equals("save")) {
            commandComponent2.add(path)
        }
        if (commandComponent2.size == 3) {
            commandComponent2[0] = commandComponent2[0] + " " + commandComponent2[1]
            commandComponent2[1] = commandComponent2[2]
            commandComponent2.removeAt(2)
        }
        if (commandComponent2.size == 1) {
            commandComponent2.add("")
        }
        return commandComponent2
    }


}
