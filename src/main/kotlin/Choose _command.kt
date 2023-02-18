class Choose_command: Create_command {
    val history= listOf<String>().toMutableList()
    val list_of_command3= listOf<Command>(create_update_id())
    val list_of_command2=listOf<Command>(create_save(), create_history())
    val list_of_command1= listOf<Command>(create_help(), create_exit(),create_show(), createe_info(),create_clear(), create_max_by_name(), create_print_field_descending_average_mark())
    val list_of_command4= listOf<Command>(create_delete_by_key_max(), create_delete_by_key_min(), create_count_less_than_group_admin(), create_insert(), create_remove())
    fun choose_coomand(collection: Collection, path: String){
        while (true){
            val coomand = readln().toLowerCase()
            if (history.size>12){
                history.removeAt(0)
                history.add(coomand)
            }
            else{
                history.add(coomand)
            }
            val command_component1= coomand.split(" ").toMutableList()
            val command_component2: MutableList<String> = listOf<String>().toMutableList()
            for (i in command_component1){
                if (!(i.equals(""))) command_component2.add(i)
            }
            if (command_component2[0].equals("history")){
                command_component2.add(history.toString())
            }
            else{
                command_component2.add(path)
            }
            if (coomand.matches("""[ ]*[a-z_]{1,}[ ]*""".toRegex())){
                for (i in list_of_command1){
                    if (i.get_name().equals(command_component2[0])){
                        i._do(collection)
                    }
                }
            }
            if ((coomand.matches("""\t*[a-z_]{1,}[ ]{1,}[A-Za-z_\.\/]{1,}""".toRegex())) or ((command_component2[0]+" "+command_component2[1]).matches("""\t*[a-z_]{1,}[ ]{1,}[ \[\]\,A-Za-z_\.\/]{1,}""".toRegex()))){
                for (i in list_of_command2){
                    if (i.get_name().equals(command_component2[0])){
                        i._do(collection, command_component2[1])
                    }
                }
            }
            if (coomand.matches("""\t*[a-z_]{1,}[ ]{1,}[a-z_]{1,}[ ]{1,}\d{1,}\t*""".toRegex())){
                for (i in list_of_command3){
                    if (i.get_name().equals(command_component2[0]+" "+command_component2[1])){
                        i._do(collection, command_component2[2].toInt())
                    }
                }
            }
            if (coomand.matches("""\t*[a-z_]{1,}[ ]{1,}-[a-z]{1}\d{1,}\t*""".toRegex())){
                for (i in list_of_command4){
                    if (i.get_name().equals(command_component2[0])){
                        i._do(collection, command_component2[1].toUpperCase())
                    }
                }
            }
        }
    }

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
}