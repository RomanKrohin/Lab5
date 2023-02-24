package Commands

class Command_exit: Command() {

    //Команды заканчивает работу приложения
    override fun _do(collection: Collections.Collection, key: String) {
        System.exit(0)
    }

}