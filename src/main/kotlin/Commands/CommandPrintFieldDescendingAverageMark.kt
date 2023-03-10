package Commands

import Exceptions.CommandException
import StudyGroupInformation.StudyGroup

class CommandPrintFieldDescendingAverageMark: Command() {
    /**
     * Класс команды, которая выводит в порядке убывания значение поля average mark всех объектов
     */

    //Команда выводит в порядке убывания значение поля average mark всех объектов
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            val list: MutableList<Int> = listOf<Int>().toMutableList()
            for (i in collection.collection.values){
                list.add(i.getAverageMark())
            }
            println(list.toList().sorted().reversed().toString())
        }
        catch (e: CommandException){
            throw e
        }
    }

}