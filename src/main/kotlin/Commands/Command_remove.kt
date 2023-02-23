package Commands

import Collections.Actions_with_collection
import Study_group_information.StudyGroup

class Command_remove: Command(), Actions_with_collection {
    override fun _do(collection: Collections.Collection, key: String) {
        execute_remove(collection, key.toUpperCase())
    }

    override fun execute_add(collection: Collections.Collection, studyGroup: StudyGroup, key: String) {
        collection.collection.put(key, studyGroup)
    }

    override fun execute_remove(collection: Collections.Collection, key: String) {
        collection.collection.remove(key)
    }

}