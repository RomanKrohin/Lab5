package WorkModuls

/**
 * Интерфейс для работы с ответами
 */
interface WorkWithAnswer {
    /**
     * Метод для создания ответа
     * @return Answer
     */
    fun createAnswer(): Answer

    /**
     * Метод для создания противоположного ответа
     * @return Answer
     */
    fun createReversedAnswer(): Answer
}