package WorkModuls

import Collections.Collection
import Commands.WorkWithHistory
import StudyGroupInformation.StudyGroup

/**
 * Класс для чтения, выборки и вывода результатов команд
 */
class Reader : WorkWithAsker, WorkWithPrinter, WorkWithTokenizator, WorkWithChooseCommand, WorkWithHistory {

    private val history = listOf<String>().toMutableList()
    private val pathsForExecuteScripts = listOf<String>().toMutableList()

    /**
     * Класс для чтения, выборки и вывода результатов команд
     * @param collection
     * @param path
     */
    fun reader(collection: Collection<String, StudyGroup>, path: String) {
        val asker = createAsker()
        val tokens = createTokenizator()
        val chooseCommand = createChooseCommand(collection, history, pathsForExecuteScripts, path)
        val printer = createPrinter()
        while (true) {
            val command = asker.askCommand()
            workWithArrayHistory(history, command)
            val commandComponents = tokens.tokenizateCommand(command, path, history)
            val answer = chooseCommand.chooseCoomand(commandComponents)
            printer.print(answer)
        }
    }

    override fun createAsker(): Asker {
        return Asker()
    }

    override fun createPrinter(): Printer {
        return Printer()
    }

    override fun createTokenizator(): Tokenizator {
        return Tokenizator()
    }

    override fun createChooseCommand(
        collection: Collection<String, StudyGroup>,
        history: MutableList<String>,
        pathsForExecuteScripts: MutableList<String>,
        pathOfFile: String,
    ): ChooseCommand {
        return ChooseCommand(collection, history, pathsForExecuteScripts, pathOfFile)
    }

    override fun workWithArrayHistory(array: MutableList<String>, coomand: String) {
        if (array.size > 12) {
            array.removeAt(0)
            array.add(coomand)
        } else {
            array.add(coomand)
        }
    }
}