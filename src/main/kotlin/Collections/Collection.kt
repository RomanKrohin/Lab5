package Collections

import StudyGroupInformation.StudyGroup
import java.util.*

class Collection<String, StudyGroup> {
    /**
     * Класс содержащий коллекцию и методы управления ею
     *
     * @param сollection коллекция HashTable
     * @constructor Пустой
     * @property Collections
     */
    var collection = Hashtable<String, StudyGroup>()
    //Блок работы с коллекцией
    /**
     * Метод для добавления объекта в коллекцию
     * @param studyGroup
     * @param key
     */
    fun add(studyGroup: StudyGroup, key: String){
        collection[key] = studyGroup
    }

    /**
     * Метод удаления объекта из коллекции
     * @param key
     */
    fun remove(key: String){
        collection.remove(key)
    }
    //
}