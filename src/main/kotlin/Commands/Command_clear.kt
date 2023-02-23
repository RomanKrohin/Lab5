package Commands

import Collections.Actions_with_collection
import Study_group_information.StudyGroup

class Command_clear : Command(), Actions_with_collection {

    override fun _do(collection: Collections.Collection, key: String) {
        for (i in collection.collection.keys){
            execute_remove(collection, i)
            collection.collection.keys.remove(i)
        }
    }
    override fun execute_add(collection: Collections.Collection, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun execute_remove(collection: Collections.Collection, key: String) {
        collection.remove(key)
    }
}