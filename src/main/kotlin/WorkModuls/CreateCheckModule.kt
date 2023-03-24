package WorkModuls

/**
 * Интерфейс для создания проверочного модуля
 */
interface CreateCheckModule {

    /**
     * Метод создания проверочного модуля
     * @return CheckModule
     */
    fun createModule(): CheckModule
}