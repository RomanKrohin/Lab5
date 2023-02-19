class Command_clear : Command(), Actions_with_collection {

    override fun _do(collection: Collection, key: String) {
        for (i in collection.collection.keys){
            execute_remove(collection, i)
            collection.collection.keys.remove(i)
        }
    }
    override fun execute_add(collection: Collection, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun execute_remove(collection: Collection, key: String) {
        collection.remove(key)
    }
}