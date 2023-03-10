package WorkModuls

interface CreateCheckModule {
    /**
     * Интерфейс для создания проверочного модуля
     */

    /**
     * Метод создания проверочного модуля
     * @return CheckModule
     */
    fun createModule(): CheckModule
}