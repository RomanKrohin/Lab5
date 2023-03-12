package Collections

import java.util.*

/**
 * Класс содержащий коллекцию и методы управления ею
 *
 * @param сollection коллекция HashTable
 * @constructor Пустой
 * @property Collections
 */
class Collection<String, StudyGroup> {
    var collection = Hashtable<String, StudyGroup>()

    /**
     * Метод для добавления объекта в коллекцию
     * @param studyGroup
     * @param key
     */
    fun add(studyGroup: StudyGroup, key: String) {
        collection[key] = studyGroup
    }

    /**
     * Метод удаления объекта из коллекции
     * @param key
     */
    fun remove(key: String) {
        collection.remove(key)
    }
    //
}