class Comand_update_id: Command(), Actions_with_collection {

    override fun _do(collection: Collection, id: String) {
        for (i in collection.collection.keys){
            if (collection.collection.get(i)?.get_id()== id.toLong()){
                val studyGroup= collection.collection.get(i)
                execute_remove(collection, i)
                println("Enter new id")
                val new_id: Long= readln().toLong()
                studyGroup?.set_id(new_id)
                execute_add(collection, studyGroup!!, i)
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