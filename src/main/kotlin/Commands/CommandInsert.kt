package Commands

import Collections.ActionsWithCollection
import StudyGroupInformation.StudyGroup
import WorkModuls.Asker
import WorkModuls.CheckModule
import WorkModuls.CreateAsker
import WorkModuls.CreateCheckModule

class CommandInsert: Command(), ActionsWithCollection, CreateCheckModule, CreateAsker {
    /**
     * Класс команды, которая добавляет объект по его ключу
     */

    //Команда добавляет в коллекцию объект с заданным ключем
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            val asker= createAsker()
            val studyGroup= asker.askStudyGroup()
            val listOfId = mutableListOf<Long>(0)
            for (i in collection.collection.values){
                listOfId.add(i.getId())
            }
            studyGroup.setId(listOfId.max()+1)
            executeAdd(collection, studyGroup, key)
        }
        catch (e: Exception){
            println("Command exception")
        }
    }

    //Интерфейсы для работы с коллекцией
    override fun executeAdd(collection: Collections.Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collections.Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
    //
    //Интерфейс создания проверочного модуля
    override fun createModule(): CheckModule {
        return CheckModule()
    }

    override fun createAsker(): Asker {
        return Asker()
    }

}