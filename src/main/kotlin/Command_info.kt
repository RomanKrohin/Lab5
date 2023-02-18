class Command_info: Command(_name = "info"){
    override fun _do(collection: Collection) {
        println("Collection: HashTable\n"+"Size "+collection.collection.size+"\n"+java.time.LocalTime.now())
    }

    override fun _do(collection: Collection, key: String) {
    }

    override fun _do(collection: Collection, new_id: Int) {
    }
}