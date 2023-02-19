class Command_delete_by_min_key: Command(), Actions_with_collection {

    override fun _do(collection: Collection, key: String) {
        if (collection.collection.keys.contains(key.toUpperCase())){
            for (i in collection.collection.keys){
                if (key.toUpperCase().hashCode()>i.hashCode()){
                    execute_remove(collection, i)
                }
            }
        }
    }


    override fun execute_add(collection: Collection, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun execute_remove(collection: Collection, key: String) {
        collection.remove(key)
    }
}