class Command_info: Command(_name = "info"){
    override fun _do(collection: Collection, list_of_keys: List<String>) {
        println("Collection: HashTable\n"+"Size "+collection.collection.size+"\n"+java.time.LocalTime.now())
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, key: String) {
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, new_id: Int) {
    }
}