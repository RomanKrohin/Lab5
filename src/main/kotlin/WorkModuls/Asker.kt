package WorkModuls

import StudyGroupInformation.*
import java.util.function.Predicate


typealias  TypeCaster<T> = (userInput: String) -> T

/**
 * Класс для работы команды insert. Пошагово вводит поля, запрпашивая от пользователя
 * введение правильных данных при их ошибочном введении
 * @param toIntCaster перевод к типу Int
 * @param toLongCaster перевод к типу Long
 */
class Asker : WorkWithPrinter {

    /**
     * Метод чтения данных, введенных пользователем и попытке привести их
     * к нужному типу данных
     *
     * @param caster
     * @param validator
     * @return T
     */
    fun <T> readType(caster: TypeCaster<T>, validator: Predicate<T>): T {
        var output: T
        while (true) {
            try {
                val userInput = readln()
                output = caster(userInput)
            } catch (e: Exception) {
                when (e) {
                    is NumberFormatException -> {
                        val printer = createPrinter()
                        printer.printHint("Некорректный ввод числа. Попробуйте еще.")
                        continue
                    }

                    is IllegalArgumentException -> {
                        val printer = createPrinter()
                        printer.printHint("Некорректный ввод enum.")
                        continue
                    }

                    else -> {
                        val printer = createPrinter()
                        printer.printHint("Некорректный ввод. Попробуйте еще.")
                        continue
                    }
                }
            }
            if (validator.test(output)) {
                break
            } else {
                Printer().printHint("Некорректный ввод. Попробуйте еще.")
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
    fun askPerson(): Person {
        val printer = createPrinter()
        printer.printHint("Введите имя админа")
        val name = readType(caster = { it }, validator = { it.isNotEmpty() })
        printer.printHint("Введите его вес")
        val weight = readType(caster = toIntCaster, validator = { it > 0 })
        printer.printHint("Введите его цвет, ${Color.values().map { it.toString() }}")
        val color = readType(caster = { toEnumCaster<Color>(it) }, validator = { true })
        printer.printHint("Введите его национальность ${Country.values().map { it.toString() }}")
        val nationality = readType(caster = { toEnumCaster<Country>(it) }, validator = { true })
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
    fun askCoordinates(): Coordinates {
        val printer = createPrinter()
        printer.printHint("Введите координату х")
        val x = readType(caster = toLongCaster, validator = { it <= 42 })
        printer.printHint("Введите координату у")
        val y = readType(caster = toLongCaster, validator = { it > -612 })
        return Coordinates(x, y)
    }

    /**
     * Метод для введения полей класса StudyGroup
     * @return StudyGroup
     */
    fun askStudyGroup(): StudyGroup {
        val printer = createPrinter()
        printer.printHint("Введите назввание группы")
        val name = readType(caster = { it }, validator = { it.isNotEmpty() })
        printer.printHint("Введите координаты")
        val coordinates = askCoordinates()
        printer.printHint("Введите колличество студентов")
        val studentCount = readType(caster = toLongCaster, validator = { it > 0 })
        printer.printHint("Введите shouldBeExpelled")
        val shouldBeExpeled = readType(caster = toIntCaster, validator = { it > 0 })
        printer.printHint("Введите среднюю оценку")
        val averageMark = readType(caster = toIntCaster, validator = { it > 0 })
        printer.printHint(
            "Введите форму обучения ${
                FormOfEducation.values().map { it.toString() }
            } или оставьте строку пустой для null"
        )
        val formOfEducation = readType(caster = { toEnumOrNullCaster<FormOfEducation>(it) }, validator = { true })
        printer.printHint("Введите поля админа")
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

    /**
     * Метод запроса команд
     * @return String
     */
    fun askCommand(): String {

        val command = readType(caster = { it }, validator = { it.isNotEmpty() })
        return command
    }

    /**
     * Метод запроса числа типа Long
     * @return Long
     */
    fun askLong(): Long {
        return readType(caster = toLongCaster, validator = { it > 0 })
    }

    override fun createPrinter(): Printer {
        return Printer()
    }
}