package WorkModuls

import Collections.Collection
import Commands.*
import StudyGroupInformation.StudyGroup

/**
 * Класс управления командами
 * @param collection
 * @param history
 * @param pathsForExecuteScripts
 * @param pathOfFile
 */
class ChooseCommand(
    collection: Collection<String, StudyGroup>,
    history: MutableList<String>,
    pathsForExecuteScripts: MutableList<String>,
    pathOfFile: String
) : CreateCommand, WorkWithAnswer, WorkWithCommandExceptionAnswer {
    val listOfPaths = pathsForExecuteScripts
    var listOfCommand = createCommnads(collection, history, listOfPaths, pathOfFile)
    val workHistory = history
    val workCollection = collection
    val workPath = pathOfFile

    /**
     * Метод выборки команд
     * @param collection
     * @param history
     * @param pathsForExecuteScripts
     * @param pathOfFile
     */
    fun chooseCoomand(commandComponent: MutableList<String>): Answer {
        commandComponent[0].lowercase()
        if (commandComponent[0] == "execute_script") {
            listOfPaths.add(commandComponent[1])
            listOfCommand = createCommnads(workCollection, workHistory, listOfPaths, workPath)
        }
        val command = listOfCommand[commandComponent[0]]?.let {
            val answer = it.commandDo(commandComponent[1])
            return answer
        }
        return createCommandExceptionAnswer(commandComponent[0])
    }

    override fun createCommnads(
        collection: Collection<String, StudyGroup>,
        history: MutableList<String>,
        pathsForExecuteScripts: MutableList<String>,
        pathOfFile: String,
    ): Map<String, Command> {
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
            "execute_script" to CommandExecuteScript(collection, history, pathsForExecuteScripts, pathOfFile)
        )
    }

    override fun createAnswer(): Answer {
        return Answer()
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

    override fun createCommandExceptionAnswer(nameCommand: String): Answer {
        val answer = createAnswer()
        answer.nameError += ": " + nameCommand
        return answer
    }
}