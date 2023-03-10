package WorkModuls

import StudyGroupInformation.*
import java.util.function.Predicate


typealias  TypeCaster<T> = (userInput: String) -> T
class Asker {
    /**
     * Класс для работы команды insert. Пошагово вводит поля, запрпашивая от пользователя
     * введение правильных данных при их ошибочном введении
     * @param toIntCaster перевод к типу Int
     * @param toLongCaster перевод к типу Long
     */

    /**
     * Метод чтения данных, введенных пользователем и попытке привести их
     * к нужному типу данных
     *
     * @param caster
     * @param validator
     * @return T
     */
    fun <T> readType(caster: TypeCaster<T>, validator: Predicate<T>): T{
        var output: T
        while (true){
            val userInput = readln()
            try {
                output = caster(userInput)
            }
            catch (e: Exception){
                when (e){
                    is NumberFormatException -> {
                        println("Некорректный ввод числа. Попробуйте еще.")
                        continue
                    }

                    is IllegalArgumentException -> {
                        println("Некорректный ввод enum.")
                        continue
                    }

                    else -> {
                        println("Некорректный ввод. Попробуйте еще.")
                        continue
                    }
                }
            }
            if (validator.test(output)){
                break
            } else{
                println("Некорректный ввод. Попробуйте еще.")
            }
        }
        return output
    }

    val toIntCaster: TypeCaster<Int> = { it.trim().toInt() }

    val toLongCaster: TypeCaster<Long> = { it.trim().toLong() }

    /**
     * Метод для приведения введенных данных к значению Enum
     * @param userInput
     */
    inline fun <reified T : Enum<T>> toEnumCaster(userInput: String): T {
        return enumValueOf(userInput.trim().uppercase())
    }

    /**
     * Метод для приведения введенных данных к значению Enum (с учетом того, что данные могут быть null)
     * @param userInput
     */
    inline fun <reified T : Enum<T>> toEnumOrNullCaster(userInput: String): T? {
        if (userInput.isEmpty()) {
            return null
        }
        return toEnumCaster<T>(userInput)
    }

    /**
     * Метод для введения полей класса Person
     * @return Person
     */
    fun askPerson(): Person{
        println("Введите имя админа")
        val name = readType(caster = { it }, validator = {it.isNotEmpty()})
        println("Введите его вес")
        val weight = readType(caster = toIntCaster, validator = {it >0})
        println("Введите его цвет, ${Color.values().map { it.toString() }}")
        val color = readType(caster = {toEnumCaster<Color>(it)}, validator = {true})
        println("Введите его национальность ${Country.values().map { it.toString() }}")
        val nationality = readType(caster = {toEnumCaster<Country>(it)}, validator = {true})
        return Person(
            name,
            weight,
            color,
            nationality
        )
    }
    /**
     * Метод для введения полей класса Coordinates
     * @return Coordinates
     */
    fun askCoordinates(): Coordinates{
        println("Введите координату х")
        val x = readType(caster = toLongCaster, validator = { it <= 42})
        println("Введите координату у")
        val y = readType(caster = toLongCaster, validator = {it>-612})
        return Coordinates(x, y)
    }
    /**
     * Метод для введения полей класса StudyGroup
     * @return StudyGroup
     */
    fun askStudyGroup(): StudyGroup{
        println("Введите назввание группы")
        val name = readType(caster = { it }, validator = {it.isNotEmpty()})
        println("Введите координаты")
        val coordinates= askCoordinates()
        println("Введите колличество студентов")
        val studentCount = readType(caster = toLongCaster, validator = {it>0})
        println("Введите shouldBeExpelled")
        val shouldBeExpeled= readType(caster = toIntCaster, validator = {it >0})
        println("Введите среднюю оценку")
        val averageMark = readType(caster = toIntCaster, validator = {it >0})
        println("Введите форму обучения ${FormOfEducation.values().map { it.toString() }} или оставьте строку пустой для null")
        val formOfEducation = readType(caster = {toEnumOrNullCaster<FormOfEducation>(it)}, validator = {true})
        println("")
        val person = askPerson()
        return StudyGroup(
            name,
            coordinates,
            studentCount,
            shouldBeExpeled,
            averageMark,
            formOfEducation,
            person
        )
    }
}