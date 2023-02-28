package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import StudyGroupInformation.StudyGroup
import java.util.*

class CommandRemove: Command(), ActionsWithCollection {

    //Команда удаляет объект из коллекции по его ключу
    override fun commandDo(collection: Collection<String, StudyGroup>, key: String) {
        try {
            executeRemove(collection, key.uppercase(Locale.getDefault()))
        }
        catch (e: Exception){
            println("Command exception")
            e.printStackTrace()
        }
    }
    //Интерфейсы для работы с коллекцией
    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.collection.put(key, studyGroup)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.collection.remove(key)
    }
    //
}