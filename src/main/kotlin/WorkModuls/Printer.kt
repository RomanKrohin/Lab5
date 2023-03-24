package WorkModuls

/**
 * Класс вывода ответа или подсказок в терминал
 */
class Printer {

    /**
     * Метод для вывода ответа
     * @param answer
     */
    fun print(answer: Answer) {
        println(answer.getAnswer())
    }

    /**
     * Метод для вывода подсказок
     * @param string
     */
    fun printHint(string: String) {
        println(string)
    }
}