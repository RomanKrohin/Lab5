class Command_exit: Command(_name = "exit") {
    override fun _do(collection: Collection, list_of_keys: List<String>) {
        System.exit(0)
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, key: String) {
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, new_id: Int) {
    }
}