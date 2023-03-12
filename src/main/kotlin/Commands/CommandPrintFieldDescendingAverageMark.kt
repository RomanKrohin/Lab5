package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer

/**
 * Класс команды, которая выводит в порядке убывания значение поля average mark всех объектов
 */
class CommandPrintFieldDescendingAverageMark(workCollection: Collections.Collection<String, StudyGroup>) : Command(),
    WorkWithAnswer {
    var collection: Collection<String, StudyGroup>

    init {
        collection = workCollection
    }

    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            val answer = createReversedAnswer()
            val list: MutableList<Int> = listOf<Int>().toMutableList()
            for (i in collection.collection.values) {
                list.add(i.getAverageMark())
            }
            answer.setterResult(list.toList().sorted().reversed().toString())
            return answer
        } catch (e: CommandException) {
            return createAnswer()
        }
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "print_field_descending_average_mark")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

}