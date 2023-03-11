package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.*
import java.io.BufferedReader
import java.io.FileReader
import java.util.*

class CommandExecuteScript(workCollection: Collection<String, StudyGroup>, workHistory: MutableList<String>): Command(), CreateCommand, WorkWithTokenizator, WorkWithAnswer, WorkWithPrinter {
    var collection: Collection<String, StudyGroup>
    var history: MutableList<String>
    init {
        history=workHistory
        collection=workCollection
    }
    /**
     * Класс команды, которая читает файл и выполняет команды, написанные в нем
     */
    //Команда читает файл и выполняет команды, написанные в нем

    //Коллекция в которой сохранены все экземпляры команд
    //Метод работы команды
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            val tokenizator= createTokenizator()
            val answer= createReversedAnswer()
            val printer= createPrinter()
            //Считывание компоненты пути к файлу
            val components= key.split(" ").toMutableList()
            //Чтение файла
            val bufferedReader= BufferedReader(FileReader(components.get(0)))
            var coomand = ""
            //Цикл считывает строки из файла и нормализует их, производит выборку и реализует метод работы команды
            while (true){
                if (bufferedReader.ready()){
                    coomand=bufferedReader.readLine()
                    val commandComponent= tokenizator.tokenizateCommand(coomand, components[1], history)
                    val listOfCommand= createCommnads(collection, history)
                    listOfCommand.get(commandComponent[0])?.commandDo(components[1])?.let { printer.print(it) }
                }
                else{
                    break
                }
            }
            return answer
        }
        catch (e: CommandException){
            return createAnswer()
        }
    }

    override fun createCommnads(collection: Collection<String, StudyGroup>, history: MutableList<String>): Map<String, Command> {
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
            "remove" to CommandRemove(collection)
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
}