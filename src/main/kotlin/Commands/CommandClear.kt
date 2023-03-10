package Commands

import Collections.ActionsWithCollection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup

class CommandClear : Command(), ActionsWithCollection {
    /**
     * Класс команды очищающая коллекцию
     */

    //Команда очищающая колекцию
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            //Цикл выдергивает объекты по их ключам
            for (i in collection.collection.keys){
                executeRemove(collection, i)
                collection.collection.keys.remove(i)
            }
        }
        catch (e: CommandException){
            throw e
        }

    }
    override fun executeAdd(collection: Collections.Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collections.Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
}