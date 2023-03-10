package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup

class ComandUpdateId: Command(), ActionsWithCollection {
    //Команда обновления id у объекта
    /**
     * Класс команды, которая обновляет id объекта коллекции по его ключу
     */

    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            //Метод находит объект по его ключу и если id, которые хотят установить уникален в рамках данной коллекции,
            //то он меняет id на переданный команде
            for (i in collection.collection.keys){
                if (collection.collection.get(i)?.getId()== key.toLong()){
                    val studyGroup= collection.collection.get(i)
                    executeRemove(collection, i)
                    println("Enter new id")
                    //Ввод нового id
                    val new_id: Long= readln().toLong()
                    studyGroup?.setId(new_id)
                    executeAdd(collection, studyGroup!!, i)
                }
            }
        }
        catch (e: CommandException){
            throw e
        }

    }
    //Интерфейсы для работы с коллекцией
    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
    //
}