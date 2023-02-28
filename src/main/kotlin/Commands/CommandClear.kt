package Commands

import Collections.ActionsWithCollection
import StudyGroupInformation.StudyGroup

class CommandClear : Command(), ActionsWithCollection {

    //Команда очищающая колекцию
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            //Цикл выдергивает объекты по их ключам
            for (i in collection.collection.keys){
                executeRemove(collection, i)
                collection.collection.keys.remove(i)
            }
        }
        catch (e: Exception){
            println("Command exception")
            e.printStackTrace()
        }

    }
    override fun executeAdd(collection: Collections.Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collections.Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
}