package Commands

import StudyGroupInformation.StudyGroup

abstract class Command() {
    /**
     * Класс-родитель команд
     */
    //Абстрактный класс от которого наследуются все другие команды
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    abstract fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String)

}