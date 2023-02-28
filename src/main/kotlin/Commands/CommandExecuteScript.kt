package Commands

import Collections.Collection
import StudyGroupInformation.StudyGroup
import WorkModuls.CreateCommand
import java.io.BufferedReader
import java.io.FileReader
import java.util.*

class CommandExecuteScript: Command(), ChangeLine, CreateCommand {
    //Команда читает файл и выполняет команды, написанные в нем

    //Коллекция в которой сохранены все экземпляры команд
    val list_of_command= createCommnads()
    //Метод работы команды
    override fun commandDo(collection: Collection<String, StudyGroup>, key: String) {
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
                    list_of_command.get(command_component[0])?.commandDo(collection, command_component[1])
                }
                else{
                    break
                }
            }
        }
        catch (e: Exception){
            println("Command exception")
            e.printStackTrace()
        }
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
    override fun createCommnads(): Map<String, Command> {
        return mapOf<String, Command>(
            "show" to CommandShow(),
            "update id" to ComandUpdateId(),
            "save" to CommandSave(),
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
            "remove" to CommandRemove()
        )
    }
}