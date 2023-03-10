package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import java.util.*

class CommandDeleteByMaxKey: Command(), ActionsWithCollection {
    //Команада удаляет объекты, значение ключа которого больше чем у заданного
    /**
     * Класс команды, которая удаляет объекты, значение ключа которого больше чем у заданного
     */

    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collection<String, StudyGroup>, key: String) {
        try {
            //Цикл проходиться по коллекции и удаляет подходящие под условие объекты
            if (collection.collection.keys.contains(key.uppercase(Locale.getDefault()))){
                for (i in collection.collection.keys){
                    if (key.uppercase(Locale.getDefault()).hashCode()<i.hashCode()){
                        executeRemove(collection,i)
                    }
                }
            }
        }
        catch (e: CommandException){
            throw e
        }
    }

    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
}