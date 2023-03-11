package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.CreateCommand
import java.io.BufferedReader
import java.io.FileReader
import java.util.*

class CommandExecuteScript(workCollection: Collection<String, StudyGroup>): Command(), ChangeLine, CreateCommand {
    var collection: Collection<String, StudyGroup>
    init {
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
        val answer= Answer()
        try {
            //Считывание компоненты пути к файлу
            val components= key.split(" ").toMutableList()
            //Чтение файла
            val bufferedReader= BufferedReader(FileReader(components.get(0)))
            var coomand = ""
            //Цикл считывает строки из файла и нормализует их, производит выборку и реализует метод работы команды
            while (true){
                if (bufferedReader.ready()){
                    coomand=bufferedReader.readLine()
                    val command_component= returnCommandComponents(coomand, components[1])
                    val listOfCommand= createCommnads(collection)
                    listOfCommand.get(command_component[0])?.commandDo(components[1])
                }
                else{
                    break
                }
            }
        }
        catch (e: CommandException){
            throw e
        }
        return answer
    }

    //Блок нормализации строки (такой же, как и при выборке команды, но без блока команды: history и execute_script)
    override fun returnCommandComponents(command: String, path: String): MutableList<String> {
        val command_component1= command.split(" ").toMutableList()
        val command_component2: MutableList<String> = listOf<String>().toMutableList()
        for (i in command_component1){
            if (!(i.equals(""))) command_component2.add(i)
        }
        if (command_component2[0].equals("save")){
            command_component2.add(path)
        }
        if (command_component2.size==3){
            command_component2[0]=command_component2[0]+" "+command_component2[1]
            command_component2[1]=command_component2[2]
            command_component2.removeAt(2)
        }
        if (command_component2.size==1){
            command_component2.add("")
        }
        command_component2[1].uppercase(Locale.getDefault())
        return command_component2
    }
    override fun createCommnads(collection: Collection<String, StudyGroup>): Map<String, Command> {
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
}