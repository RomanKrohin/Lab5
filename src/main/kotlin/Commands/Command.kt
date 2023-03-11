package Commands

import WorkModuls.Answer

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
    abstract fun commandDo(key: String): Answer

}