class Choose_command: Create_command {
    val list_of_command= listOf<Command>(create_help(), create_exit(),create_show(), createe_info())
    fun choose_coomand(collection: Collection, count_key: Int){
        while (true){
            var coomand = readln()
            for (i in 0..list_of_command.size-1){
                if (coomand.equals(list_of_command[i].get_name())){
                    list_of_command[i]._do(collection, count_key)
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
}