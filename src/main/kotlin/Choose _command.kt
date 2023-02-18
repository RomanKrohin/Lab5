class Choose_command: Create_command {
    val list_of_command3= listOf<Command>(create_update_id())
    val list_of_command1= listOf<Command>(create_help(), create_exit(),create_show(), createe_info(),create_clear(), create_max_by_name())
    val list_of_command4= listOf<Command>(create_delete_by_key_max(), create_delete_by_key_min())
    fun choose_coomand(collection: Collection, list_of_keys: List<String>){
        while (true){
            val coomand = readln().toLowerCase()
            val command_component1= coomand.split(" ").toMutableList()
            val command_component2: MutableList<String> = listOf<String>().toMutableList()
            for (i in command_component1){
                if (!(i.equals(""))) command_component2.add(i)
            }
            if (coomand.matches("""[ ]*[a-z_]{1,}[ ]*""".toRegex())){
                for (i in list_of_command1){
                    if (i.get_name().equals(command_component2[0])){
                        i._do(collection, list_of_keys)
                    }
                }
            }
            if (coomand.matches("""\t*[a-z_]{1,}\t{1,}[a-z_]{1,}""".toRegex())){
                println(2)
            }
            if (coomand.matches("""\t*[a-z_]{1,}[ ]{1,}[a-z_]{1,}[ ]{1,}\d{1,}\t*""".toRegex())){
                for (i in list_of_command3){
                    if (i.get_name().equals(command_component2[0]+" "+command_component2[1])){
                        i._do(collection, list_of_keys, command_component2[2].toInt())
                    }
                }
            }
            if (coomand.matches("""\t*[a-z_]{1,}[ ]{1,}-[a-z]{1}\d{1,}\t*""".toRegex())){
                for (i in list_of_command4){
                    if (i.get_name().equals(command_component2[0])){
                        i._do(collection, list_of_keys, command_component2[1].toUpperCase())
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
}