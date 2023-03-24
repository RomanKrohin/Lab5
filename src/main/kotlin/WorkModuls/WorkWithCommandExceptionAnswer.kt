package WorkModuls

/**
 * Интерфейс для создания ответа ошибки
 */
interface WorkWithCommandExceptionAnswer {

    /**
     * Метод создания ответа ошибки
     * @param nameCommand
     * @return Answer
     */
    fun createCommandExceptionAnswer(nameCommand: String): Answer
}