class Command_exit: Command() {

    override fun _do(collection: Collection, key: String) {
        System.exit(0)
    }

}