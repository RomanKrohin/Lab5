package Commands

import Exceptions.CommandException
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer

/**
 * Класс команды, которая выводит список доступных команд
 */
class CommandHelp : Command(), WorkWithAnswer {

    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            val answer = createReversedAnswer()
            answer.setterResult(
                "help : вывести справку по доступным командам\n" +
                        "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                        "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "insert {key} : добавить новый элемент с заданным ключом\n" +
                        "update id {id} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "remove {key} : удалить элемент из коллекции по его ключу\n" +
                        "clear : очистить коллекцию\n" +
                        "save : сохранить коллекцию в файл\n" +
                        "execute_script {path to file} : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                        "exit : завершить программу (без сохранения в файл)\n" +
                        "remove_lower_key {key} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                        "remove_greater_key {key} : удалить из коллекции все элементы, ключ которых превышает заданный\n" +
                        "average_of_students_count : вывести среднее значение поля studentsCount для всех элементов коллекции\n" +
                        "print_field_descending_should_be_expelled : вывести значения поля shouldBeExpelled всех элементов в порядке убывания" +
                        "history : вывести в терминал последние 12 введенных команд\n" +
                        "max_by_name : вывести в терминал текстовый вид объекта, значение поля name которого наибольшее\n" +
                        "count_less_than_group_admin : вывести в терминал текстовый вид объекта, значение поля group admin которого наибольшее\n"
            )
            return answer
        } catch (e: CommandException) {
            return createAnswer()
        }
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Help")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

}