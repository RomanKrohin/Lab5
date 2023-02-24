package Collections

import Study_group_information.StudyGroup
import java.util.*

class Collection {
    var collection = Hashtable<String, StudyGroup>()
    //Блок работы с коллекцией
    fun add(studyGroup: StudyGroup, key: String){
        collection.put(key, studyGroup)
    }
    fun remove(key: String){
        collection.remove(key)
    }
    //
}