package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*

/**
 * Класс команды, которая читает файл и выполняет команды, написанные в нем
 */
class CommandExecuteScript(
    workCollection: Collection<String, StudyGroup>,
    workHistory: MutableList<String>,
    pathsForExecuteScripts: MutableList<String>,
    pathOfFile: String,
) : Command(), CreateCommand, WorkWithTokenizator, WorkWithAnswer, WorkWithPrinter, WorkWithHistory,
    WorkWithCommandExceptionAnswer {
    var collection: Collection<String, StudyGroup>
    var history: MutableList<String>
    val path = pathOfFile

    init {
        history = workHistory
        collection = workCollection
    }

    var listOfCommand = createCommnads(collection, history, pathsForExecuteScripts, pathOfFile)
    val listOfPaths = pathsForExecuteScripts

    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            val tokenizator = createTokenizator()
            val printer = createPrinter()
            if(!File(key).isFile){
                return createAnswer();
            }
            val bufferedReader = BufferedReader(FileReader(key))
            while (true) {
                if (bufferedReader.ready()) {
                    val commandComponent = tokenizator.tokenizateCommand(bufferedReader.readLine(), path, history)
                    if (commandComponent[0] != "execute_script") {
                        if (listOfCommand.keys.contains(commandComponent[0])) {
                            listOfCommand.get(commandComponent[0])
                                ?.let { printer.print(it.commandDo(commandComponent[1])) }
                        } else {
                            printer.printHint("Некорректные команда: ${commandComponent[0]}")
                        }
                    } else {
                        if (!(listOfPaths.contains(commandComponent[1]))) {
                            listOfPaths.add(commandComponent[1])
                            val workCommand = CommandExecuteScript(collection, history, listOfPaths, path)
                            printer.print(workCommand.commandDo(commandComponent[1]))
                        } else {
                            printer.printHint("Данный файл уже был использован: " + commandComponent[1])
                        }
                    }
                } else {
                    break
                }
            }
            return createReversedAnswer()
        } catch (e: CommandException) {
            return createAnswer()
        }
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
            "history" to CommandHistory(collection)
        )
    }

    override fun createTokenizator(): Tokenizator {
        return Tokenizator()
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Execute script")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

    override fun createPrinter(): Printer {
        return Printer()
    }

    override fun workWithArrayHistory(array: MutableList<String>, coomand: String) {
        if (array.size > 12) {
            array.removeAt(0)
            array.add(coomand)
        } else {
            array.add(coomand)
        }
    }

    override fun createCommandExceptionAnswer(nameCommand: String): Answer {
        val answer = createAnswer()
        answer.nameError += ": " + nameCommand
        return answer
    }
}