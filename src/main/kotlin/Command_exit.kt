class Command_exit: Command(_name = "exit") {
    override fun _do(collection: Collection, count_key: Int) {
        System.exit(0)
    }
}