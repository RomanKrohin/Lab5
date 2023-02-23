package Commands

class Command_exit: Command() {

    override fun _do(collection: Collections.Collection, key: String) {
        System.exit(0)
    }

}