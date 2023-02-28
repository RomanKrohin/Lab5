package Commands

import Collections.ActionsWithCollection
import StudyGroupInformation.StudyGroup
import WorkModuls.CheckModule
import WorkModuls.CreateCheckModule

class CommandInsert: Command(), ActionsWithCollection, CreateCheckModule {

    //Команда добавляет в коллекцию объект с заданным ключем
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {

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

}