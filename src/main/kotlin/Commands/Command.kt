package Commands

import StudyGroupInformation.StudyGroup

abstract class Command() {
    //Абстрактный класс от которого наследуются все другие команды
    abstract fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String)

}