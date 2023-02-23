package Commands

import Collections.Actions_with_collection
import Study_group_information.StudyGroup

class Comand_update_id: Command(), Actions_with_collection {

    override fun _do(collection: Collections.Collection, key: String) {
        for (i in collection.collection.keys){
            if (collection.collection.get(i)?.get_id()== key.toLong()){
                val studyGroup= collection.collection.get(i)
                execute_remove(collection, i)
                println("Enter new id")
                val new_id: Long= readln().toLong()
                studyGroup?.set_id(new_id)
                execute_add(collection, studyGroup!!, i)
            }
        }
    }

    override fun execute_add(collection: Collections.Collection, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun execute_remove(collection: Collections.Collection, key: String) {
        collection.remove(key)
    }
}