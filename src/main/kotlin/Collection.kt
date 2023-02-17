import java.util.*

class Collection {
    var collection = Hashtable<String, StudyGroup>()
    fun add(studyGroup: StudyGroup, key: String){
        collection.put(key, studyGroup)
    }
}