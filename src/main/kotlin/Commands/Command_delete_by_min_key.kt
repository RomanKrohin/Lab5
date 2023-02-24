package Commands

import Collections.Actions_with_collection
import Study_group_information.StudyGroup

class Command_delete_by_min_key: Command(), Actions_with_collection {

    //Команда удаляет объекты значение ключа которых меньше чем у заданного

    override fun _do(collection: Collections.Collection, key: String) {
        //Цикл проходиться по коллекции, сравнивает и удаляет подходящие объекты
        if (collection.collection.keys.contains(key.toUpperCase())){
            for (i in collection.collection.keys){
                if (key.toUpperCase().hashCode()>i.hashCode()){
                    execute_remove(collection, i)
                }
            }
        }
    }


    override fun execute_add(collection: Collections.Collection, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun execute_remove(collection: Collections.Collection, key: String) {
        collection.remove(key)
    }
}