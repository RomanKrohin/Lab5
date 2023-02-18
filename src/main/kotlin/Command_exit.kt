class Command_exit: Command(_name = "exit") {
    override fun _do(collection: Collection) {
        System.exit(0)
    }

    override fun _do(collection: Collection, key: String) {
    }

    override fun _do(collection: Collection, new_id: Int) {
    }
}