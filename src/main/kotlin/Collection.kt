class Collection {
    val collection = HashMap<Int, StudyGroup>()
    fun add(studyGroup: StudyGroup, key: Int){
        collection.put(key, studyGroup)
    }
}