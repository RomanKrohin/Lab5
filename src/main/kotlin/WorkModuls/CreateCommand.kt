package WorkModuls

import Commands.Command

interface CreateCommand {
    /**
     * Интерфейс для создания массива с командыми
     */

    /**
     * Метод для создания массива команд
     * @return Map<String, Command>
     */
    fun createCommnads() : Map<String, Command>
}