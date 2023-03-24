package WorkModuls

/**
 * Интерфейс для работы с классом токенизатора
 */
interface WorkWithTokenizator {

    /**
     * Метод для создания экземпляра класс токенизатора
     * @return Tokenizator
     */
    fun createTokenizator(): Tokenizator
}