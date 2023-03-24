package WorkModuls

/**
 * Интерфейс для работы с классом запроса
 */
interface WorkWithAsker {

    /**
     * Метод для создания экземпляра класса запроса
     * @return Asker
     */
    fun createAsker(): Asker
}