class Command_delete_by_min_key: Command(_name = "remove_lower_key"), Actions_with_collection {
    override fun _do(collection: Collection) {
    }

    override fun _do(collection: Collection, key: String) {
        if (collection.collection.keys.contains(key)){
            for (i in collection.collection.keys){
                if (key.hashCode()>i.hashCode()){
                    execute_remove(collection, i)
                }
            }
        }
    }

    override fun _do(collection: Collection, new_id: Int) {
    }

    override fun execute_add(collection: Collection, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun execute_remove(collection: Collection, key: String) {
        collection.remove(key)
    }
}