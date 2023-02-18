class Command_clear : Command(_name = "clear"), Actions_with_collection {
    override fun _do(collection: Collection) {
        for (i in collection.collection.keys){
            execute_remove(collection, i)
            collection.collection.keys.remove(i)
        }
    }

    override fun _do(collection: Collection, key: String) {

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