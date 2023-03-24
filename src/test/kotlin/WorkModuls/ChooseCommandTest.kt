package WorkModuls

import StudyGroupInformation.StudyGroup
import org.junit.jupiter.api.Test

class ChooseCommandTest {

    @Test
    fun testChooseCommandClear() {
        val collection= createCollection()
        val history = listOf<String>().toMutableList()
        val pathsForExecuteScripts = listOf<String>().toMutableList()
        val pathOfFile=""
        val commandComponents = listOf<String>().toMutableList()
        commandComponents.add("clear")
        commandComponents.add("")
        val chooseCommand= ChooseCommand(collection, history, pathsForExecuteScripts, pathOfFile)
        val buf= chooseCommand.chooseCoomand(commandComponents)
        assert(buf.getAnswer().equals("Success\n----------\n"))
    }
    @Test
    fun testChooseCommandInfo(){
        val collection= createCollection()
        val history = listOf<String>().toMutableList()
        val pathsForExecuteScripts = listOf<String>().toMutableList()
        val pathOfFile=""
        val commandComponents = listOf<String>().toMutableList()
        commandComponents.add("info")
        commandComponents.add("")
        val chooseCommand= ChooseCommand(collection, history, pathsForExecuteScripts, pathOfFile)
        val buf= chooseCommand.chooseCoomand(commandComponents)
        assert(buf.getAnswer().contains("Size "+collection.collection.size))
    }


    @Test
    fun testChooseCommandExecuteScript(){
        val collection= createCollection()
        val history = listOf<String>().toMutableList()
        val pathsForExecuteScripts = listOf<String>().toMutableList()
        val pathOfFile=""
        val commandComponents = listOf<String>().toMutableList()
        commandComponents.add("execute_script")
        commandComponents.add("")
        val chooseCommand= ChooseCommand(collection, history, pathsForExecuteScripts, pathOfFile)
        val buf= chooseCommand.chooseCoomand(commandComponents)
        assert(buf.getAnswer().equals("Command exception: Execute script"))
    }

    @Test
    fun testChooseCommandHelp(){
        val collection= createCollection()
        val history = listOf<String>().toMutableList()
        val pathsForExecuteScripts = listOf<String>().toMutableList()
        val pathOfFile=""
        val commandComponents = listOf<String>().toMutableList()
        commandComponents.add("help")
        commandComponents.add("")
        val chooseCommand= ChooseCommand(collection, history, pathsForExecuteScripts, pathOfFile)
        val buf= chooseCommand.chooseCoomand(commandComponents)
        assert(buf.getAnswer().equals("help : вывести справку по доступным командам\n" +
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
                "count_less_than_group_admin : вывести в терминал текстовый вид объекта, значение поля group admin которого наибольшее\n"))
    }

    @Test
    fun testChooseCommandWrongCommand(){
        val collection= createCollection()
        val history = listOf<String>().toMutableList()
        val pathsForExecuteScripts = listOf<String>().toMutableList()
        val pathOfFile=""
        val commandComponents = listOf<String>().toMutableList()
        commandComponents.add("awdawd")
        commandComponents.add("")
        val chooseCommand= ChooseCommand(collection, history, pathsForExecuteScripts, pathOfFile)
        val buf= chooseCommand.chooseCoomand(commandComponents)
        assert(buf.getAnswer().equals("Command exception: Command do not exist"))
    }
    fun createCollection(): Collections.Collection<String, StudyGroup> {
        return Collections.Collection()
    }
}