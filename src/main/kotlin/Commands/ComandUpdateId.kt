package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.*

class ComandUpdateId(workCollection: Collection<String, StudyGroup>) : Command(), ActionsWithCollection, WorkWithPrinter, WorkWithAnswer {
    var collection: Collection<String, StudyGroup>

    init {
        collection = workCollection
    }
    //Команда обновления id у объекта
    /**
     * Класс команды, которая обновляет id объекта коллекции по его ключу
     */

    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            val answer = createReversedAnswer()
            val printer= createPrinter()
            //Метод находит объект по его ключу и если id, которые хотят установить уникален в рамках данной коллекции,
            //то он меняет id на переданный команде
            for (i in collection.collection.values) {
                if (i.getId() == key.toLong()) {
                    printer.printHint("Enter new id")
                    //Ввод нового id
                    val newId: Long = Asker().askLong()
                    i.setId(newId)
                }
            }
            return answer
        } catch (e: CommandException) {
            return createAnswer()
        }
    }

    //Интерфейсы для работы с коллекцией
    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }

    override fun createPrinter(): Printer {
        return Printer()
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Update id")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }
    //
}