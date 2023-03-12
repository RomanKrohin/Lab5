package Commands

import WorkModuls.Answer

/**
 * Класс-родитель команд
 */
abstract class Command() {

    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    abstract fun commandDo(key: String): Answer

}