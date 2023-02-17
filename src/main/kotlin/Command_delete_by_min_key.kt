class Command_delete_by_min_key: Command(_name = "remove_lower_key") {
    override fun _do(collection: Collection, list_of_keys: List<String>) {
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, key: String) {
        if (list_of_keys.contains(key)){
            for (i in list_of_keys){
                if (key.hashCode()>i.hashCode()){
                    collection.collection.remove(i)
                }
            }
        }
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, new_id: Int) {
    }
}