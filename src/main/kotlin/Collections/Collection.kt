package Collections

import StudyGroupInformation.StudyGroup
import java.util.*

class Collection<String, StudyGroup> {
    var collection = Hashtable<String, StudyGroup>()
    //Блок работы с коллекцией
    fun add(studyGroup: StudyGroup, key: String){
        collection[key] = studyGroup
    }
    fun remove(key: String){
        collection.remove(key)
    }
    //
}