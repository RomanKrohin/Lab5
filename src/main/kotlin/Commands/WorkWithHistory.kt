package Commands

/**
 * Интерфейс для работы с коллекцией
 */
interface WorkWithHistory {


    /**
     * Метод работы коллекции
     * @param array
     * @param coomand
     */
    fun workWithArrayHistory(array: MutableList<String>, coomand: String)
}