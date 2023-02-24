package Commands

import Work_moduls.Create_command
import java.io.BufferedReader
import java.io.FileReader

class Command_execute_script: Command(), Change_line, Create_command {
    //Команда читает файл и выполняет команды, написанные в нем

    //Коллекция в которой сохранены все экземпляры команд
    val list_of_command= mapOf<String, Command>("show" to create_show(), "update id" to create_update_id(),"save" to create_save(),"help" to create_help(), "exit" to create_exit(), "info" to createe_info(), "clear" to create_clear(), "max_by_name" to create_max_by_name(), "print_field_descending_average_mark" to create_print_field_descending_average_mark(),"remove_greater_key" to create_delete_by_key_max(),"remove_lower_key" to create_delete_by_key_min(),"count_less_than_group_admin" to create_count_less_than_group_admin(),"insert" to create_insert(),"remove" to create_remove())

    //Метод работы команды
    override fun _do(collection: Collections.Collection, key: String) {
        //Считывание компоненты пути к файлу
        val components= key.split(" ").toMutableList()
        //Чтение файла
        val bufferedReader= BufferedReader(FileReader(components.get(0)))
        var coomand = ""
        //Цикл считывает строки из файла и нормализует их, производит выборку и реализует метод работы команды
            while (true){
                if (bufferedReader.ready()){
                    coomand=bufferedReader.readLine()
                    val command_component= return_command_components(coomand, components[1])
                    list_of_command.get(command_component[0])?._do(collection, command_component[1])
                }
                else{
                    break
                }
            }
    }

    //Блок нормализации строки (такой же, как и при выборке команды, но без блока команды: history и exexute_script)
    override fun return_command_components(command: String, path: String): MutableList<String> {
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
        command_component2[1].toUpperCase()
        return command_component2
    }
    //Блок создание экземпляров команд
    override fun create_help(): Command {
        return Command_help()
    }

    override fun create_exit(): Command {
        return Command_exit()
    }

    override fun create_show(): Command {
        return Command_show()
    }

    override fun createe_info(): Command {
        return Command_info()
    }

    override fun create_update_id(): Command {
        return Comand_update_id()
    }

    override fun create_clear(): Command {
        return Command_clear()
    }

    override fun create_max_by_name(): Command {
        return Command_max_name()
    }

    override fun create_delete_by_key_max(): Command {
        return Command_delete_by_max_key()
    }

    override fun create_delete_by_key_min(): Command {
        return Command_delete_by_min_key()
    }

    override fun create_count_less_than_group_admin(): Command {
        return Command_count_less_than_admin()
    }

    override fun create_print_field_descending_average_mark(): Command {
        return Command_print_field_descending_average_mark()
    }

    override fun create_insert(): Command {
        return Command_insert()
    }

    override fun create_save(): Command {
        return Command_save()
    }

    override fun create_remove(): Command {
        return Command_remove()
    }

    override fun create_history(): Command {
        return `Command_ history`()
    }

    override fun create_execute_script(): Command {
        return Command_execute_script()
    }
    //
}