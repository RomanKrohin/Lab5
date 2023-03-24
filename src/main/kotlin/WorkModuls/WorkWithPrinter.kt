package WorkModuls

/**
 * Интерфейс для работы с классом вывода
 */
interface WorkWithPrinter {

    /**
     * Метод для создания экземпляра класса вывода
     * @return Printer
     */
    fun createPrinter(): Printer
}