package WorkModuls

/**
 * Класс ответа, в его экземплярах хранятся результаты выполнения команд
 * @param checkError
 * @param nameError
 * @param result
 */
data class Answer(
    var checkError: Boolean = true,
    var nameError: String = "Command do not exist",
    var result: String = "Command exception: ",
) {
    init {
        if (checkError) {
            result += nameError
        }
        if (!checkError) {
            result = "Success\n----------\n"
        }
    }

    /**
     * Метод установки результата
     * @param resultCommand
     */
    fun setterResult(resultCommand: String) {
        result = resultCommand
    }

    /**
     * Метод выдачи ответа
     * @return String
     */
    fun getAnswer(): String {
        return result
    }
}