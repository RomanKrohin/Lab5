class `Command_ history` : Command(_name = "history") {
    override fun _do(collection: Collection) {
    }

    override fun _do(collection: Collection, history: String) {
        println(history)
    }

    override fun _do(collection: Collection, new_id: Int) {
    }
}