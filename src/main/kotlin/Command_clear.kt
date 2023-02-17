class Command_clear : Command(_name = "clear") {
    override fun _do(collection: Collection, list_of_keys: List<String>) {
        for (i in list_of_keys){
            collection.collection.remove(i)
            collection.collection.keys.remove(i)
        }
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, key: String) {

    }

    override fun _do(collection: Collection, list_of_keys: List<String>, new_id: Int) {
    }
}