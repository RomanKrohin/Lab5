package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer

class CommandPrintFieldDescendingAverageMark(workCollection: Collections.Collection<String, StudyGroup>): Command() {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection
    }
    /**
     * Класс команды, которая выводит в порядке убывания значение поля average mark всех объектов
     */

    //Команда выводит в порядке убывания значение поля average mark всех объектов
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        val answer= Answer()
        try {
            val list: MutableList<Int> = listOf<Int>().toMutableList()
            for (i in collection.collection.values){
                list.add(i.getAverageMark())
            }
            answer.setterResult(list.toList().sorted().reversed().toString())
        }
        catch (e: CommandException){
            throw e
        }
        return Answer()
    }

}