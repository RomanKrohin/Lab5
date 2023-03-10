package Commands

interface ChangeLine {
    /**
     * Интерфейс для разделения строки введенной пользователем на компоненты
     */

    /**
     * Метод для возвращения компоненты команд
     * @param command
     * @param path
     * @return MutableList<String>
     */
    fun returnCommandComponents(command: String, path: String): MutableList<String>
}