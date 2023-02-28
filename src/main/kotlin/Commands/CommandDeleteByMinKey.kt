package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import StudyGroupInformation.StudyGroup
import java.util.*

class CommandDeleteByMinKey: Command(), ActionsWithCollection {

    //Команда удаляет объекты значение ключа которых меньше чем у заданного

    override fun commandDo(collection: Collection<String, StudyGroup>, key: String) {
        try {
            //Цикл проходиться по коллекции, сравнивает и удаляет подходящие объекты
            if (collection.collection.keys.contains(key.uppercase(Locale.getDefault()))){
                for (i in collection.collection.keys){
                    if (key.uppercase(Locale.getDefault()).hashCode()>i.hashCode()){
                        executeRemove(collection, i)
                    }
                }
            }
        }
        catch (e: Exception){
            println("Command exception")
            e.printStackTrace()
        }
    }

    //Интерфейсы для работы с коллекцией
    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
    //
}