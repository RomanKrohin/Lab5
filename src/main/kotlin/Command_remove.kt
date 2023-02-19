class Command_remove: Command(), Actions_with_collection {
    override fun _do(collection: Collection, key: String) {
        execute_remove(collection, key.toUpperCase())
    }

    override fun execute_add(collection: Collection, studyGroup: StudyGroup, key: String) {
        collection.collection.put(key, studyGroup)
    }

    override fun execute_remove(collection: Collection, key: String) {
        collection.collection.remove(key)
    }

}